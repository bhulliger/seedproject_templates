package @package@;

import com.gwtplatform.dispatch.rpc.shared.Action;

public class LoginAction implements Action<LoginResult> {
	
	private String username;
	private String password;

	public LoginAction(String username, String password) {
		this.username = username;
		this.password = password;
	}

	protected LoginAction() {
		// Possibly for serialization
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String getServiceName() {
		return "dispatch/";
	}

	@Override
	public boolean isSecured() {
		return false;
	}

}

	