package lu.bnl.archiveit.client;

import java.io.IOException;

import org.apache.http.client.protocol.HttpClientContext;

import lu.bnl.archiveit.client.api.auth.ArchiveitSession;
import lu.bnl.archiveit.client.api.auth.Authorization;
import lu.bnl.archiveit.client.api.auth.AuthorizationProvider;
import lu.bnl.archiveit.client.api.services.AccountService;
import lu.bnl.archiveit.client.api.services.AuthenticationService;
import lu.bnl.archiveit.client.api.services.CollectionService;
import lu.bnl.archiveit.client.api.services.CrawlService;
import lu.bnl.archiveit.client.api.services.SeedService;
import lu.bnl.archiveit.client.api.services.WarcService;
import lu.bnl.archiveit.client.exceptions.ArchiveItApiException;


/**
 * Provides functionality to communicate with ArchiveIt's API services.
 *
 */
public class ArchiveitClient implements AuthorizationProvider
{
	// The current session (authenticated or not)
	private ArchiveitSession session;
	
	// Services
	private CollectionService collectionService;
	private SeedService seedService;
	private AccountService accountService;
	private AuthenticationService authenticationService;
	private WarcService warcService;
	private CrawlService crawlService;
	
	/**
	 * The default constructor. This will connect to Archive-It *WITHOUT* authentication. Only
	 * publicly visible information will be returned by the API.
	 * 
	 * For getting more information, use the constructor with a username and password.
	 * 
	 */
	public ArchiveitClient()
	{
		this.session = new ArchiveitSession();
		
		setupServices();
	}
	
	public ArchiveitClient(String username, String password)
	{
		// Set up the basic session
		Authorization auth = new Authorization();
		auth.setUsername(username);
		auth.setPassword(password);
		this.session = new ArchiveitSession();
		this.session.setAuth(auth);
		
		// Now we set up the API services
		setupServices();
	}
	
	private void setupServices()
	{
		this.collectionService = new CollectionService(this);
		this.seedService = new SeedService(this);
		this.accountService = new AccountService(this);
		this.authenticationService = new AuthenticationService(this);
		this.warcService = new WarcService(this);
		this.crawlService = new CrawlService(this);
	}
	
	/**
	 * If not already connected, logs in to the server using the given credentials.
	 * 
	 */
	public void connect() throws ArchiveItApiException, IOException
	{
		HttpClientContext sessionContext = authenticationService.login();
		
		this.session.setContext(sessionContext);
	}
	
	public CollectionService getCollectionService() 
	{
		return collectionService;
	}

	public SeedService getSeedService() 
	{
		return seedService;
	}

	public AccountService getAccountService() 
	{
		return accountService;
	}
	
	public WarcService getWarcService() 
	{
		return warcService;
	}
	
	public CrawlService getCrawlService() 
	{
		return crawlService;
	}

	@Override
	public ArchiveitSession getSession() 
	{
		return session;
	}

	
}
