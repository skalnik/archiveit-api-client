package lu.bnl.archiveit.client.utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;

import lu.bnl.archiveit.client.api.auth.ArchiveitSession;
import lu.bnl.archiveit.client.exceptions.HttpRequestFailedException;


public class HttpUtils 
{

	public static String executeAuthenticatedGetRequest(String fullUrl, ArchiveitSession session) throws IOException, HttpRequestFailedException
	{
		// Construct the client
		CloseableHttpClient client = HttpClients.custom().build();

		try
		{
			// Construct the request
			HttpGet get = new HttpGet(fullUrl);
			
			Header headers[] = { new BasicHeader("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9"),
								 new BasicHeader("X-CSRFToken", session.getCsrfToken())
							   };
			
			get.setHeaders(headers);
			
			// Do it!
			CloseableHttpResponse response = client.execute(get, session.getContext());
			
			// Check status
			int status = response.getStatusLine().getStatusCode();
			if (status != HttpStatus.SC_OK)
			{
				throw new HttpRequestFailedException("Server returned status code " + status + " with message '" + response.getStatusLine().getReasonPhrase() + "'");
			}
			
			// Done
			String result = IOUtils.toString(response.getEntity().getContent(), StandardCharsets.UTF_8);
			return result;
		}
		finally
		{
			// Close the stream gracefully
			client.close();
		}
	}
	
	
	public static String executePostRequest(String fullUrl, List<NameValuePair> payload, ArchiveitSession session) throws IOException, HttpRequestFailedException
	{
		// Construct the request
		CloseableHttpClient client = HttpClients.custom().build();
		HttpPost post = new HttpPost(fullUrl);

		// Insert the headers
		Header headers[] = { new BasicHeader("accept", "text/html,application/xhtml+xml,application/xml;q=0.8,application/signed-exchange;v=b3;q=0.9"),
							 new BasicHeader("X-CSRFToken", session.getCsrfToken())
						   };

		post.setHeaders(headers);
		
		// Create the payload
		if (payload != null && !payload.isEmpty())
		{
			post.setEntity(new UrlEncodedFormEntity(payload, "UTF-8"));
		}
	    
		// Do it!
		HttpResponse response = client.execute(post);
		
		// Check status
		int status = response.getStatusLine().getStatusCode();
		if (status != HttpStatus.SC_OK)
		{
			throw new HttpRequestFailedException("Server returned status code " + status + " with message '" + response.getStatusLine().getReasonPhrase() + "'");
		}
		
		// Done
		String result = IOUtils.toString(response.getEntity().getContent(), StandardCharsets.UTF_8);
		return result;
	}
	
}
