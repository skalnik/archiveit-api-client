package lu.bnl.archiveit.client.api.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import lu.bnl.archiveit.client.api.ApiConstants;
import lu.bnl.archiveit.client.api.auth.AuthorizationProvider;
import lu.bnl.archiveit.client.exceptions.ArchiveItApiException;

/**
 * Contains methods related to user authentication/login.
 *
 */
public class AuthenticationService extends ArchiveitApiService
{
	private static final String AUTH_ENDPOINT = ApiConstants.ARCHIVE_IT_PARTNER_API_ENDPOINT + "auth/";
	private static final String SELF_ENDPOINT = AUTH_ENDPOINT + "/list/";
	private static final String LOGIN_ENDPOINT = ApiConstants.ARCHIVE_IT_PARTNER_API_AUTH_ENDPOINT + "login/";
	
	public AuthenticationService(AuthorizationProvider auth) 
	{
		super(auth);
	}

//	public boolean isAuthenticated() throws IOException
//	{
//		try
//		{
//			// Try to get self-identification information from the server
//			String result = HttpUtils.executeAuthenticatedGetRequest(SELF_ENDPOINT, getAuthorizationProvider().getSession());
//		
//			// Deserialize the response
//			Gson gson = new Gson();
//			User entity = gson.fromJson(result, User.class);
//			
//			return (entity != null);
//		}
//		catch (Exception e)
//		{
//			return false;
//		}
//	}
	
	/**
	 * Authenticates with Archive-It using the credentials given by the provider, then returns
	 * the context (including cookies and the CSRF token) to the caller.
	 */
	public HttpClientContext login() throws ArchiveItApiException, IOException
	{
		try
		{
			// Get a context for this session
			HttpClientContext context = getAuthenticationContext();
			List<Cookie> cookies = context.getCookieStore().getCookies();

			// Perform the authenticated login (if credentials are available)
			CloseableHttpClient httpclient = createClient();	
			HttpPost httpPost = new HttpPost(LOGIN_ENDPOINT);

	        // Set the CSRF token and cookie in the headers of the request
			httpPost.setHeader("X-CSRFToken", getCsrfTokenFromCookieList(cookies));

		    // Set the username and password in the body of the request
			List<NameValuePair> payload = new ArrayList<NameValuePair>();
			payload.add(new BasicNameValuePair("username", getAuthorizationProvider().getSession().getAuth().getUsername()));
			payload.add(new BasicNameValuePair("password", getAuthorizationProvider().getSession().getAuth().getPassword()));
			httpPost.setEntity(new UrlEncodedFormEntity(payload));

		    // Execute the request and handle the response
		    HttpResponse postResponse = httpclient.execute(httpPost, context); // The context contains the cookies
		    int status = postResponse.getStatusLine().getStatusCode();
		      
			if (status == ApiConstants.ARCHIVE_IT_SUCCESSFUL_LOGIN) 
			{
		        // Handle successful authentication
		        System.out.println("Authenticated successfully");
		    }
			else if (status >= 400)
			{
		        // Handle authentication failure
			    String message = EntityUtils.toString(postResponse.getEntity());
		        System.out.println("Authentication failed (status code " + status + "): " + message);
		    }
			else
			{
				System.out.println("Proceeding without authenticated API access");
			}
			
			// We're done!
	        httpclient.close();
	        
			return context;
		}
		catch (IOException e)
		{
			throw new ArchiveItApiException("Could not log in: " + e.getMessage());
		}
	}
	
	/**
	 * Gets cookies and the CSRF token to be used for authentication later on.
	 * 
	 */
	private HttpClientContext getAuthenticationContext() throws IOException
	{
		// The client and its context
		CloseableHttpClient httpclient = createClient();
		HttpClientContext context = HttpClientContext.create();

		// Execute the request
	    HttpGet httpGet = new HttpGet(LOGIN_ENDPOINT);
		httpclient.execute(httpGet, context);
		
		// Now return the context
		return context;
	}

	private CloseableHttpClient createClient()
	{
		// MAke sure to use the correct cookie standard for Archive-It
	    RequestConfig config = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build();

	    return HttpClients.custom().setDefaultRequestConfig(config).build();
	}

	private String getCsrfTokenFromCookieList(List<Cookie> cookies)
	{
		for (Cookie cookie : cookies)
		{
			if (cookie.getName().equals("csrftoken"))
				return cookie.getValue();
	    }
		
		return "";
	}
	
}
