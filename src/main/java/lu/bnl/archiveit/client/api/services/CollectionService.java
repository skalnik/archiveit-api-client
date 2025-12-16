package lu.bnl.archiveit.client.api.services;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

import lu.bnl.archiveit.client.api.ApiConstants;
import lu.bnl.archiveit.client.api.auth.AuthorizationProvider;
import lu.bnl.archiveit.client.exceptions.ArchiveItApiException;
import lu.bnl.archiveit.client.exceptions.HttpRequestFailedException;
import lu.bnl.archiveit.client.model.Collection;
import lu.bnl.archiveit.client.utils.HttpUtils;

/**
 * Contains methods related to Archive-It collections.
 *
 */
public class CollectionService extends ArchiveitApiService
{
	
	private static final String COLLECTION_ENDPOINT = ApiConstants.ARCHIVE_IT_PARTNER_API_ENDPOINT + "collection";
	
	public CollectionService(AuthorizationProvider auth)
	{
		super(auth);
	}
	
	public Collection getCollectionById(int id) throws IOException, ArchiveItApiException
	{
		try
		{
			// Construct and execute the query
			String result = HttpUtils.executeAuthenticatedGetRequest(COLLECTION_ENDPOINT + "?format=json&id=" + id, getAuthorizationProvider().getSession());
			
			// Deserialize the response
			Gson gson = new Gson();
			Collection[] entity = gson.fromJson(result, Collection[].class);
				
			// We're done!
			if (entity.length == 0)
				return null;
			else
				return entity[0];
		}
		catch (IOException | HttpRequestFailedException e)
		{
			throw new ArchiveItApiException("Could not get collection: " + e.getMessage());
		}
	}
	
	public List<Collection> getCollectionsByAccountId(int accountId) throws IOException, ArchiveItApiException
	{
		try
		{
			// Construct and execute the query
			String result = HttpUtils.executeAuthenticatedGetRequest(COLLECTION_ENDPOINT + "?format=json&limit=" + ApiConstants.NO_LIMIT + "&account=" + accountId, getAuthorizationProvider().getSession());

			// Deserialize the response
			Gson gson = new Gson();
			Collection[] entity = gson.fromJson(result, Collection[].class);
				
			// We're done!
			return Arrays.asList(entity);
		}
		catch (IOException | HttpRequestFailedException e)
		{
			throw new ArchiveItApiException("Could not get collection: " + e.getMessage());
		}
	}
	
}
