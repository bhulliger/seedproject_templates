package @package@;

import @base@.shared.model.CurrentUser;
import com.google.web.bindery.event.shared.EventBus;
import com.google.gwt.event.shared.GwtEvent;

public class LoginAuthenticatedEvent extends GwtEvent<LoginAuthenticatedEventHandler> {
	
	private static final Type<LoginAuthenticatedEventHandler> TYPE = new Type<LoginAuthenticatedEventHandler>();

	public static Type<LoginAuthenticatedEventHandler> getType() {
		return TYPE;
	}

	private CurrentUser currentUser;

	public static void fire(EventBus eventBus, CurrentUser currentUser) {
		eventBus.fireEvent(new LoginAuthenticatedEvent(currentUser));
	}

	public LoginAuthenticatedEvent(CurrentUser currentUser) {
		this.currentUser = currentUser;
	}

	public CurrentUser getCurrentUser() {
		return this.currentUser;
	}

	@Override
	public void dispatch(LoginAuthenticatedEventHandler handler) {
		handler.onLogin(this);
	}

	@Override
	public Type<LoginAuthenticatedEventHandler> getAssociatedType() {
		return getType();
	}

}