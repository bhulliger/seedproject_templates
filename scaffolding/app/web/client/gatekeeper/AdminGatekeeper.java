package @package@;

import javax.inject.Inject;

import com.gwtplatform.mvp.client.proxy.Gatekeeper;
import @shared@.model.CurrentUser;

public class AdminGatekeeper implements Gatekeeper {
	
	private final CurrentUser currentUser;

	@Inject
	public AdminGatekeeper(CurrentUser currentUser) {
		this.currentUser = currentUser;
	}

	@Override
	public boolean canReveal() {
		return currentUser.getRoles().contains("ROLE_ADMIN");
	}
}