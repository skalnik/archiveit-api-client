package lu.bnl.archiveit.client.api.services;

import lu.bnl.archiveit.client.api.auth.AuthorizationProvider;

public abstract class ArchiveitApiService 
{
	private AuthorizationProvider auth;
	
	public ArchiveitApiService(AuthorizationProvider auth)
	{
		this.auth = auth;
	}

	public AuthorizationProvider getAuthorizationProvider() {
		return auth;
	}
	
}
