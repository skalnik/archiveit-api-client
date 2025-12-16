package lu.bnl.archiveit.client.api.auth;

/**
 * Provides means of authenticating an API request to Archive-It.
 *
 */
public interface AuthorizationProvider
{
	public ArchiveitSession getSession();
}
