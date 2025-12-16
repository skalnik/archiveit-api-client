package lu.bnl.archiveit.client.api.auth;

/**
 * Access to the private Archive-It API is cookie-based. This structure holds user credentials and 
 * the current cookie information.
 *
 */
public class Authorization 
{
	private String username = "";
	
	private String password = "";

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Authorization [username=" + username + ", password=" + password + "]";
	}

}
