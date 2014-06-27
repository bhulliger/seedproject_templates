package @package@;

import com.google.gwt.i18n.client.Constants;

public interface AppConfig extends Constants {

	@DefaultStringValue("@version@")
	String version();

	@DefaultStringValue("@buildDate@")
	String buildDate();

}