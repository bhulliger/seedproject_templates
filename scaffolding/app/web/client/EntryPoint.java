package @package@;

import java.util.logging.Level;
import java.util.logging.Logger;

import @app@;
import @injector@;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;

public class @className@ implements EntryPoint {

	private static final Logger logger = Logger.getLogger("");

	private Injector injector = GWT.create(Injector.class);

	@Override
	public void onModuleLoad() {

		GWT.setUncaughtExceptionHandler(new GWT.UncaughtExceptionHandler() {

			@Override
			public void onUncaughtException(Throwable e) {
				logger.log(Level.WARNING, "uncaught exception in client: " + e.getMessage(), e);
				Window.alert(e.getLocalizedMessage());
			}
		});

		startApp();
	}

	private void startApp() {
		App app = injector.getApp();
		RootPanel.get().add(app);
	}
	
}