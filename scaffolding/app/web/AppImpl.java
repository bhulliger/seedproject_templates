package @package@;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class AppImpl extends Composite implements App {

	interface AppImplUiBinder extends UiBinder<Widget, AppImpl> {}

	private static AppImplUiBinder uiBinder = GWT.create(AppImplUiBinder.class);
	
	private Presenter presenter;

	@Inject
	public AppImpl() {
		super();

		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

}