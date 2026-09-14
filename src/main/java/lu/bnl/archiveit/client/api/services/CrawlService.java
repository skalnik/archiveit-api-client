package lu.bnl.archiveit.client.api.services;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

import lu.bnl.archiveit.client.api.ApiConstants;
import lu.bnl.archiveit.client.api.auth.AuthorizationProvider;
import lu.bnl.archiveit.client.exceptions.ArchiveItApiException;
import lu.bnl.archiveit.client.exceptions.HttpRequestFailedException;
import lu.bnl.archiveit.client.model.CrawlJob;
import lu.bnl.archiveit.client.model.CrawlLog;
import lu.bnl.archiveit.client.model.CrawlingMachine;
import lu.bnl.archiveit.client.utils.HttpUtils;

/**
 * Contains methods related to crawls in Archive-It.
 *
 */
public class CrawlService extends ArchiveitApiService
{
	
	private static final String CRAWLING_MACHINE_ENDPOINT = ApiConstants.ARCHIVE_IT_PARTNER_API_ENDPOINT + "crawling_machine";

	private static final String CHANGELOG_ENDPOINT = ApiConstants.ARCHIVE_IT_PARTNER_API_ENDPOINT + "changelog";
	
	private static final String CRAWL_JOB_ENDPOINT = ApiConstants.ARCHIVE_IT_PARTNER_API_ENDPOINT + "crawl_job";

	
	public CrawlService(AuthorizationProvider auth)
	{
		super(auth);
	}
	
	public List<CrawlingMachine> getCrawlingMachines() throws IOException, ArchiveItApiException
	{
		try
		{
			// Construct and execute the query
			String result = HttpUtils.executeAuthenticatedGetRequest(CRAWLING_MACHINE_ENDPOINT + "?format=json", getAuthorizationProvider().getSession());
			
			// Deserialize the response
			Gson gson = new Gson();
			CrawlingMachine[] entity = gson.fromJson(result, CrawlingMachine[].class);
				
			// We're done!
			return Arrays.asList(entity);
		}
		catch (IOException | HttpRequestFailedException e)
		{
			throw new ArchiveItApiException("Could not get crawling machines: " + e.getMessage());
		}
	}
	
	public List<CrawlLog> getCrawlLogs() throws IOException, ArchiveItApiException
	{
		try
		{
			// Construct and execute the query
			String result = HttpUtils.executeAuthenticatedGetRequest(CHANGELOG_ENDPOINT + "?format=json&limit=" + ApiConstants.NO_LIMIT, getAuthorizationProvider().getSession());
			
			// Deserialize the response
			Gson gson = new Gson();
			CrawlLog[] entity = gson.fromJson(result, CrawlLog[].class);
				
			// We're done!
			return Arrays.asList(entity);
		}
		catch (IOException | HttpRequestFailedException e)
		{
			throw new ArchiveItApiException("Could not get crawl logs: " + e.getMessage());
		}
	}
	
	
	public List<CrawlJob> getCrawlJobs() throws IOException, ArchiveItApiException
	{
		try
		{
			// Construct and execute the query
			String result = HttpUtils.executeAuthenticatedGetRequest(CRAWL_JOB_ENDPOINT + "?format=json&limit=" + ApiConstants.NO_LIMIT, getAuthorizationProvider().getSession());
			
			// Deserialize the response
			Gson gson = new Gson();
			CrawlJob[] entity = gson.fromJson(result, CrawlJob[].class);
				
			// We're done!
			return Arrays.asList(entity);
		}
		catch (IOException | HttpRequestFailedException e)
		{
			throw new ArchiveItApiException("Could not get crawl logs: " + e.getMessage());
		}
	}
	
}
