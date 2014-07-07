package @package@;

import javax.inject.Inject;

import @base@.client.event.LoginAuthenticatedEvent;
import @base@.shared.model.CurrentUser;

import com.google.gwt.event.shared.EventBus;
import com.gwtplatform.mvp.client.proxy.Gatekeeper;


public class AdminGatekeeper implements Gatekeeper {

	private final EventBus eventBus;
	
	private CurrentUser currentUser;

	@Inject
	public AdminGatekeeper(final EventBus eventBus) {
		this.eventBus = eventBus;

		this.eventBus.addHandler(LoginAuthenticatedEvent.getType(),
				event -> currentUser = event.getCurrentUser());
		
	}

	@Override
	public boolean canReveal() {
		boolean isAdmin = false;

		if (currentUser != null) {
			isAdmin = currentUser.isAdmin();
		}

		return isAdmin;
	}
}