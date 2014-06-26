package @package@;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class Navigation extends Composite {

	interface NavigationUiBinder extends UiBinder<Widget, Navigation> {
	}

	private static NavigationUiBinder uiBinder = GWT.create(NavigationUiBinder.class);

	public Navigation() {
		super();

		initWidget(uiBinder.createAndBindUi(this));
	}

}