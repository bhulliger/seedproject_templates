/**
 * Copyright 2012 Brigitte Hulliger
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package @package@;

import javax.inject.Inject;

import org.fusesource.restygwt.client.Method;
import org.gwtbootstrap3.client.ui.AnchorButton;
import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.Div;
import org.gwtbootstrap3.client.ui.Input;
import org.gwtbootstrap3.client.ui.ListDropDown;
import org.gwtbootstrap3.client.ui.ListItem;
import org.gwtbootstrap3.client.ui.TextBox;

import @base@.client.place.NameTokens;
import @base@.client.resources.AppResources;
import @base@.client.ws.AbstractRestCallback;
import @base@.client.ws.BasicRestClient;
import @base@.shared.model.CurrentUser;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;

public class Header extends Composite {

	interface Binder extends UiBinder<Widget, Header> {
	}

	@UiField ListItem home; // NOSONAR
	
	@UiField TextBox username; // NOSONAR
	@UiField Input password; // NOSONAR
	@UiField Button signin; // NOSONAR
	
	@UiField ListDropDown authenticatedMenu; // NOSONAR
	@UiField AnchorButton authenticatedUser; // NOSONAR
	@UiField ListItem profile; // NOSONAR
	@UiField ListItem signout; // NOSONAR
	
	@UiField Div anonymous; // NOSONAR
	@UiField Div authenticated; // NOSONAR

	private PlaceManager placeManager;

	private BasicRestClient basicRestClient;

	private CurrentUser currentUser;

	@Inject
	public Header(Binder binder, PlaceManager placeManager, BasicRestClient basicRestClient, AppResources resources, CurrentUser currentUser) {

		this.placeManager = placeManager;
		this.basicRestClient = basicRestClient;

		initWidget(binder.createAndBindUi(this));

		anonymous.addStyleName(resources.styles().headerForm());

		anonymous.setVisible(currentUser.getUsername() == null);
		authenticated.setVisible(currentUser.getUsername() != null);

	}

	@UiHandler("signin")
	void onSignin(ClickEvent event) {

		anonymous.setVisible(false);


		// TODO do the authentication
		authenticatedUser.setText(currentUser.getUsername());
		authenticated.setVisible(true);
		
	}

	@UiHandler("signout")
	void onSignout(ClickEvent event) {

		// TODO Auto-generated method stub

		authenticatedUser.setText(null);
		authenticated.setVisible(false);

		anonymous.setVisible(true);
	}

	@UiHandler("profile")
	void onProfile(ClickEvent event) {
		PlaceRequest request = new PlaceRequest.Builder().nameToken(NameTokens.profilePage).build();
		placeManager.revealPlace(request);
	}

	@UiHandler("home")
	void onHome(ClickEvent event) {
		PlaceRequest request = new PlaceRequest.Builder().nameToken(
				NameTokens.homePage).build();

		placeManager.revealPlace(request);
	}

}