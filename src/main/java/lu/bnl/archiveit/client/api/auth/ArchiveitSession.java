package lu.bnl.archiveit.client.api.auth;

import java.util.List;

import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.cookie.Cookie;

/**
 * Contains all information concerning an authenticated session with ArchiveIt.
 *
 */
public class ArchiveitSession 
{
	// The session context contains the list of cookies, including the CSRF token
	private HttpClientContext context;
	
	// Credentials
	private Authorization auth;
	
	public ArchiveitSession()
	{
		this.context = new HttpClientContext();
		this.auth = new Authorization();
	}
	
	public HttpClientContext getContext() {
		return context;
	}

	public void setContext(HttpClientContext context) {
		this.context = context;
	}

	public Authorization getAuth() {
		return auth;
	}

	public void setAuth(Authorization auth) {
		this.auth = auth;
	}

	public String getCsrfToken()
	{
		for (Cookie cookie : getCookies()) 
		{
			if (cookie.getName().equals("csrftoken"))
				return cookie.getValue();
	    }
		
		return "";
	}
	
	public List<Cookie> getCookies()
	{
		return context.getCookieStore().getCookies();
	}
	
	public String dumpCookies()
	{
		String res = "[ ";
		
		for (Cookie cookie : getCookies())
		{
			res += cookie.getName() + "=" + cookie.getValue() + " ";
		}
		
		res += "]";
		
		return res;
	}
}
