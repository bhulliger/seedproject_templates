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

import @base@.shared.validation.FieldVerifier;
import @base@.client.i18n.AppMessages;

import org.gwtbootstrap3.client.ui.Alert;
import org.gwtbootstrap3.client.ui.Input;
import org.gwtbootstrap3.client.ui.Button;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

public class SigninView extends ViewWithUiHandlers<SigninUiHandlers> implements SigninPresenter.MyView {
    public interface Binder extends UiBinder<Widget, SigninView> {
    }

    @UiField Alert alert; // NOSONAR
    @UiField Label alertMessage; // NOSONAR

    @UiField Button signin; // NOSONAR
    @UiField Input username; // NOSONAR
    @UiField Input password; // NOSONAR

    private AppMessages messages; 

    @Inject
    public SigninView(Binder uiBinder, AppMessages messages) {
        initWidget(uiBinder.createAndBindUi(this));
        this.messages = messages;
    }

    @UiHandler("signin")
    void onSignin(ClickEvent event) {

    	if (FieldVerifier.isValidUsername(getUsername()) && FieldVerifier.isValidPassword(getPassword())) {
            alert.setVisible(false);
	    	if (getUiHandlers() != null) {
	    		getUiHandlers().onSignin();
	    	}
    	} else {
            showAlert(messages.invalidCredentialsTitle(), messages.invalidCredentialsMessage());
            
            alert.setVisible(true);
            resetAndFocus();
    	}

    }

    @Override
    public String getUsername() {
    	return this.username.getText();
    }

    @Override
    public String getPassword() {
    	return this.password.getText();
    }

    @Override
    public void showAlert(String title, String message) {
        alert.setTitle(title);
        alertMessage.setText(message);
        alert.setVisible(true);
    }

    @Override
    public void hideAlert() {
        alert.setVisible(false);
    }

    @Override
    public void resetAndFocus() {
        this.username.setFocus(true);
        this.username.selectAll();
    }
}
