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

import @base@.shared.validation.FieldVerifier;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

public class SigninView extends ViewWithUiHandlers<SigninUiHandlers> implements SigninPresenter.MyView {
    public interface Binder extends UiBinder<Widget, SigninView> {
    }

    @Inject
    public SigninView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiHandler("signin")
    void onSignin(ClickEvent event) {

    	if (FieldVerifier.isValidUsername(getUsername()) && FieldVerifier.isValidPassword(getPassword())) {

	    	if (getUiHandlers() != null) {
	    		getUiHandlers().onSignin();
	    	}
    	} else {
    		event.cancel();
    		SC.say("sign in", "you must enter a valid username and password."); // FIXME
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
}
