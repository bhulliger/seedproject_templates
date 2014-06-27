package @package@;

import com.google.gwt.i18n.client.Messages;

public interface AppMessages extends Messages {

	@DefaultMessage("Version: {0}")
	public String buildNumber(String buildNumber);

	@DefaultMessage("Date: {0}")
	public String buildDate(String buildDate);


}