package @package@;

import org.gwtbootstrap3.client.ui.AnchorButton;
import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.Div;
import org.gwtbootstrap3.client.ui.Input;
import org.gwtbootstrap3.client.ui.ListDropDown;
import org.gwtbootstrap3.client.ui.ListItem;
import org.gwtbootstrap3.client.ui.TextBox;

import @base@.client.resources.AppResources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class Header extends Composite implements ClickHandler {

	interface HeaderUiBinder extends UiBinder<Widget, Header> {
	}

	private static HeaderUiBinder uiBinder = GWT.create(HeaderUiBinder.class);

	@UiField ListItem home; // NOSONAR
	
	@UiField TextBox username; // NOSONAR
	@UiField Input password; // NOSONAR
	@UiField Button signin; // NOSONAR
	
	@UiField ListDropDown authenticatedMenu; // NOSONAR
	@UiField AnchorButton authenticatedUser; // NOSONAR
	@UiField ListItem signout; // NOSONAR
	@UiField ListItem profile; // NOSONAR
	
	@UiField Div anonymous; // NOSONAR
	@UiField Div authenticated; // NOSONAR

	public Header() {
		AppResources.CSS.main().ensureInjected();
		initWidget(uiBinder.createAndBindUi(this));

		anonymous.addStyleName(AppResources.CSS.main().headerForm());

		signin.addClickHandler(this);
		signout.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				// TODO Auto-generated method stub

				authenticatedUser.setText("");
				authenticated.setVisible(false);

				anonymous.setVisible(true);

			}
		});
		signout.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				home.setActive(false);
				authenticatedMenu.setActive(true);

			}
		});

		home.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				home.setActive(true);
				authenticatedMenu.setActive(false);

			}

		});

		anonymous.setVisible(true);
		authenticated.setVisible(false);
	}


	@Override
	public void onClick(ClickEvent event) {
		if (event.getSource().equals(signin)) {

			// TODO Auto-generated method stub

			anonymous.setVisible(false);

			authenticatedUser.setText("Hans Maulwurf"); 
			authenticated.setVisible(true);
		} 


	}

}