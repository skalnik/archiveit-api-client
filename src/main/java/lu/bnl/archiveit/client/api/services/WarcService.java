package lu.bnl.archiveit.client.api.services;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

import lu.bnl.archiveit.client.api.ApiConstants;
import lu.bnl.archiveit.client.api.auth.AuthorizationProvider;
import lu.bnl.archiveit.client.exceptions.ArchiveItApiException;
import lu.bnl.archiveit.client.exceptions.HttpRequestFailedException;
import lu.bnl.archiveit.client.model.Warc;
import lu.bnl.archiveit.client.model.WasapiWarcResponse;
import lu.bnl.archiveit.client.utils.HttpUtils;

/**
 * Contains methods related to WARC files in Archive-It.
 *
 */
public class WarcService extends ArchiveitApiService
{
	
	private static final String METADATA_ENDPOINT = ApiConstants.ARCHIVE_IT_WARCAPI_ENDPOINT + "webdata";
	
	public WarcService(AuthorizationProvider auth)
	{
		super(auth);
	}
	
	public List<Warc> getWarcsByCollectionId(int id) throws IOException, ArchiveItApiException
	{
		try
		{
			// Construct and execute the query
			String result = HttpUtils.executeAuthenticatedGetRequest(METADATA_ENDPOINT + "?format=json&collection=" + id, getAuthorizationProvider().getSession());
			
			// Deserialize the response
			Gson gson = new Gson();
			
			WasapiWarcResponse entity = gson.fromJson(result, WasapiWarcResponse.class);
			
			// We're done!
			return Arrays.asList(entity.getFiles());
		}
		catch (IOException | HttpRequestFailedException e)
		{
			throw new ArchiveItApiException("Could not get warcs: " + e.getMessage());
		}
	}

}
