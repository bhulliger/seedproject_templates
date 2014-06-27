package @package@;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;

public final class AppResources {

	private AppResources() {}

	public static final CssResources CSS = GWT.create(CssResources.class);

	public interface CssResources extends ClientBundle {

		@Source("main.css")
		MainCss main();	

		/** Add further css resources if needed */

	}
	

}