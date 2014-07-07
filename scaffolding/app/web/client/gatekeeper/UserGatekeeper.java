package @package@;

import javax.inject.Inject;

import com.gwtplatform.mvp.client.proxy.Gatekeeper;
import com.google.gwt.event.shared.EventBus;
import @shared@.model.CurrentUser;

public class UserGatekeeper implements Gatekeeper {
	
	private final EventBus eventBus;
	
	private final CurrentUser currentUser;

	@Inject
	public UserGateKeeper(final EventBus eventBus) {
		this.eventBus = eventBus;

		this.eventBus.addHandler(LoginAuthenticatedEvent.getType(), new LoginAuthenticatedEventHandler() {

			public void onLogin(LoginAuthenticatedEvent event) {
				currentUser = event.getCurrentUser();
			}

		});
		
	}

	@Override
	public boolean canReveal() {
		return currentUser != null;
	}
}