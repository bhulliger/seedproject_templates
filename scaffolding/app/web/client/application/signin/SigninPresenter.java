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

import @base@.client.place.NameTokens;
import @base@.client.ws.AbstractRestCallback;
import @base@.client.ws.BasicRestClient;
import @base@.shared.model.CurrentUser;
import @base@.shared.validation.FieldVerifier;

import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.NoGatekeeper;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;


public class SigninPresenter extends Presenter<SigninPresenter.MyView, SigninPresenter.MyProxy> implements SigninUiHandlers {

    private final EventBus eventBus;
    private final DispatchAsync dispatcher;
    private final PlaceManager placeManager;

    public interface MyView extends View, HasUiHandlers<SigninUiHandlers> {
        String getUsername();
        String getPassword();
        void resetAndFocus();
    }

    @ProxyCodeSplit
    @NameToken(NameTokens.signinPage)
    @NoGatekeeper
    public interface MyProxy extends ProxyPlace<SigninPresenter> {
    }

    @Inject
    public SigninPresenter(EventBus eventBus, MyView view, MyProxy proxy, DispatchAsync dispatcher,  PlaceManager placeManager, EventBus eventBus) {
        super(eventBus, view, proxy);

        tihs.dispatcher = dispatcher;
        this.placeManager = placeManager;
        this.eventBus = eventBus;

        view.setUiHandlers(this);
    }

    @Override
    public void onSignin() {
        authenticate(getView().getUsername(), getView().getPassword());
    }

    private void authenticate(String username, String password) {
         getDispatcher().execute(new LoginAction(username, password), new AsyncCallback<LoginResult>() {

            @Override
            public void onSuccess(LoginResult result) {
                CurrentUser currentUser = new CurrentUser(getView().getUsername());

                LoginAuthenticatedEvent.fire(eventBus, currentUser);

                PlaceRequest placeRequest = new PlaceRequest(NameTokens.homePage);
                getPlaceManager().revealPlace(placeRequest);
            }

        });

    }

    private DispatchAsync getDispatcher() {
        return dispatcher;
    }
    
    private PlaceManager getPlaceManager() {
        return placeManager;
    }

}
