package @package@;

import com.google.gwt.i18n.client.Constants;

public interface AppConstants extends Constants {

	@DefaultStringValue("Home")
	String home();

	@DefaultStringValue("Username")
	String username();

	@DefaultStringValue("Password")
	String password();

	@DefaultStringValue("Profile")
	String profile();

	@DefaultStringValue("Sign In")
	String signin();

	@DefaultStringValue("Sign out")
	String signout();

}