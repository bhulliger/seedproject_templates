package @package@;

import javax.inject.Singleton;

import @app@;
import @appImpl@;

import com.google.gwt.inject.client.AbstractGinModule;

public class InjectorModule extends AbstractGinModule {

	@Override
	protected void configure() {

		bind(App.class).to(AppImpl.class).in(Singleton.class);
		
		// TODO Auto-generated method stub

	}
	
}