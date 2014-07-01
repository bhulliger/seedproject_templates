package @package@;

import javax.inject.Inject;

import com.gwtplatform.mvp.client.proxy.Gatekeeper;
import @shared@.model.CurrentUser;

public class UserGatekeeper implements Gatekeeper {
	
	private final CurrentUser currentUser;

	@Inject
	public UserGatekeeper(CurrentUser currentUser) {
		this.currentUser = currentUser;
	}

	@Override
	public boolean canReveal() {
		return currentUser.getRoles().contains("ROLE_USER");
	}
}