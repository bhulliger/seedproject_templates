package @package@;

import javax.inject.Singleton;

import @app@;

import com.google.gwt.inject.client.AbstractGinModule;

public class InjectorModule extends AbstractGinModule {

	@Override
	protected void configure() {

		bind(App.class).in(Singleton.class);
		
		// TODO Auto-generated method stub

	}
	
}