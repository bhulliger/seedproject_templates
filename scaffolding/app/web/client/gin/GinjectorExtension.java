package @package@;

import @base@.client.i18n.AppConfig;
import @base@.client.i18n.AppConstants;
import @base@.client.i18n.AppMessages;

public interface GinjectorExtension {
	
	AppConstants getAppConstants();
	
	AppMessages getAppMessages();
	
	AppConfig getAppConfig();

}
