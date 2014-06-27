package @package@;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class Footer extends Composite {

	interface FooterUiBinder extends UiBinder<Widget, Footer> {
	}

	private static FooterUiBinder uiBinder = GWT.create(FooterUiBinder.class);

	@UiField
	Label version; // NOSONAR

	public Footer() {
		super();

		// version = new Label(messages.build(config.version()));

		initWidget(uiBinder.createAndBindUi(this));
	}
	

}