package lu.bnl.archiveit.client.api.services;

import java.io.IOException;

import com.google.gson.Gson;

import lu.bnl.archiveit.client.api.ApiConstants;
import lu.bnl.archiveit.client.api.auth.AuthorizationProvider;
import lu.bnl.archiveit.client.exceptions.ArchiveItApiException;
import lu.bnl.archiveit.client.exceptions.HttpRequestFailedException;
import lu.bnl.archiveit.client.model.Account;
import lu.bnl.archiveit.client.utils.HttpUtils;

/**
 * Contains methods related to accounts in Archive-It.
 *
 */
public class AccountService extends ArchiveitApiService
{
	private static final String ACCOUNT_ENDPOINT = ApiConstants.ARCHIVE_IT_PARTNER_API_ENDPOINT + "account";
	
	public AccountService(AuthorizationProvider auth)
	{
		super(auth);
	}
	
	public Account getAccountById(int id) throws IOException, ArchiveItApiException
	{
		try
		{
			// Construct and execute the query
			String result = HttpUtils.executeAuthenticatedGetRequest(ACCOUNT_ENDPOINT + "?format=json&id=" + id, getAuthorizationProvider().getSession());
			
			// Deserialize the response
			Gson gson = new Gson();
			Account[] entity = gson.fromJson(result, Account[].class);
				
			// We're done!
			if (entity.length == 0)
				return null;
			else
				return entity[0];
		}
		catch (IOException | HttpRequestFailedException e)
		{
			throw new ArchiveItApiException("Could not get account: " + e.getMessage());
		}
	}
	
	/**
	 * If called from a client with credentials, returns the details of the account that corresponds to those credentials.
	 * 
	 */
	public Account getMyAccount() throws IOException, ArchiveItApiException
	{
		try
		{
			// Construct and execute the query
			String result = HttpUtils.executeAuthenticatedGetRequest(ACCOUNT_ENDPOINT + "?format=json", getAuthorizationProvider().getSession());
			
			// Deserialize the response
			Gson gson = new Gson();
			Account[] entity = gson.fromJson(result, Account[].class);
				
			// We're done!
			if (entity.length == 0)
				return null;
			else
				return entity[0];
		}
		catch (IOException | HttpRequestFailedException e)
		{
			throw new ArchiveItApiException("Could not get account: " + e.getMessage());
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			throw new ArchiveItApiException("No accounts correspond to the given credentials");
		}
	}
}
