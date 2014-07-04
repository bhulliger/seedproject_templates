package @package@;

import com.gwtplatform.dispatch.rpc.shared.Result;

public class LoginResult implements Result {

	private static final long serialVersionUID = 1L;
	
	private String sessionKey;

	public LoginResult(String sessionKey) {
		this.sessionKey = sessionKey;
	}

	protected LoginResult() {
		// Possibly for serialization
	}

	public String getSessionKey() {
		return this.sessionKey;
	}

}