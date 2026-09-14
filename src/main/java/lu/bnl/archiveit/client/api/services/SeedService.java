package lu.bnl.archiveit.client.api.services;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

import lu.bnl.archiveit.client.api.ApiConstants;
import lu.bnl.archiveit.client.api.auth.AuthorizationProvider;
import lu.bnl.archiveit.client.exceptions.ArchiveItApiException;
import lu.bnl.archiveit.client.exceptions.HttpRequestFailedException;
import lu.bnl.archiveit.client.model.Seed;
import lu.bnl.archiveit.client.model.SeedReport;
import lu.bnl.archiveit.client.utils.HttpUtils;

/**
 * Contains methods related to seeds in Archive-It.
 *
 */
public class SeedService extends ArchiveitApiService
{
	
	private static final String SEED_ENDPOINT = ApiConstants.ARCHIVE_IT_PARTNER_API_ENDPOINT + "seed";

	private static final String SEED_REPORT_ENDPOINT = ApiConstants.ARCHIVE_IT_PARTNER_API_ENDPOINT + "seed_report_entry";
	
	public SeedService(AuthorizationProvider auth)
	{
		super(auth);
	}
	
	public Seed getSeedById(int id) throws IOException, ArchiveItApiException
	{
		try
		{
			// Construct and execute the query
			String result = HttpUtils.executeAuthenticatedGetRequest(SEED_ENDPOINT + "?format=json&id=" + id, getAuthorizationProvider().getSession());
			
			// Deserialize the response
			Gson gson = new Gson();
			Seed[] entity = gson.fromJson(result, Seed[].class);
			
			// We're done!
			if (entity.length == 0)
				return null;
			else
				return entity[0];
		}
		catch (IOException | HttpRequestFailedException e)
		{
			throw new ArchiveItApiException("Could not get seed: " + e.getMessage());
		}
	}
	
	public List<Seed> getSeedsByCollectionId(int collectionId) throws IOException, ArchiveItApiException
	{
		try
		{
			// Construct and execute the query
			String result = HttpUtils.executeAuthenticatedGetRequest(SEED_ENDPOINT + "?format=json&limit=" + ApiConstants.NO_LIMIT + "&collection=" + collectionId, getAuthorizationProvider().getSession());
			
			// Deserialize the response
			Gson gson = new Gson();
			Seed[] entity = gson.fromJson(result, Seed[].class);
				
			// We're done!
			return Arrays.asList(entity);
		}
		catch (IOException | HttpRequestFailedException e)
		{
			throw new ArchiveItApiException("Could not get seed: " + e.getMessage());
		}
	}
	
	public List<SeedReport> getSeedReports() throws IOException, ArchiveItApiException
	{
		try
		{
			// Construct and execute the query
			String result = HttpUtils.executeAuthenticatedGetRequest(SEED_REPORT_ENDPOINT + "?format=json&limit=" + ApiConstants.NO_LIMIT, getAuthorizationProvider().getSession());
			
			// Deserialize the response
			Gson gson = new Gson();
			SeedReport[] entity = gson.fromJson(result, SeedReport[].class);
				
			// We're done!
			return Arrays.asList(entity);
		}
		catch (IOException | HttpRequestFailedException e)
		{
			throw new ArchiveItApiException("Could not get crawl logs: " + e.getMessage());
		}
	}
	
}
