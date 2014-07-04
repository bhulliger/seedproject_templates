package @package@;

import com.google.gwt.i18n.client.Messages;

public interface AppMessages extends Messages {

	@DefaultMessage("Version: {0}")
	public String buildNumber(String buildNumber);

	@DefaultMessage("Date: {0}")
	public String buildDate(String buildDate);

	@DefaultMessage("Sign in")
	public String invalidCredentialsTitle();

	@DefaultMessage("You must enter a valid username and password.")
	public String invalidCredentialsMessage();

	@DefaultMessage("Authentication failed.")
	public String authenticationFailedTitle();

	@DefaultMessage("Invalid username and/or password.")
	public String authenticationFailedMessage();


}