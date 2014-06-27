package @package@;

import @base@.client.i18n.AppMessages;
import @base@.client.i18n.AppConfig;

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
	Label version, buildDate; // NOSONAR

	public Footer() {
		// FIXME use gin injection for resources.
		AppMessages messages = GWT.create(AppMessages.class);
		AppConfig config = GWT.create(AppConfig.class);

		version = new Label();
		buildDate = new Label();

		initWidget(uiBinder.createAndBindUi(this));

		version.setText(messages.buildNumber(config.version()));
		buildDate.setText(messages.buildDate(config.buildDate()));
	}
	

}