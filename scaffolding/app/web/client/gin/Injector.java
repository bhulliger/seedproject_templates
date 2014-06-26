package @package@;

import @app@;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

@GinModules(InjectorModule.class)
public interface Injector extends Ginjector {

	App getApp();
	
}