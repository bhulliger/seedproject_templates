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

import @base@.client.event.LoginAuthenticatedEvent;
import @base@.client.i18n.AppMessages;
import @base@.client.place.NameTokens;
import @base@.shared.action.LoginAction;
import @base@.shared.action.LoginResult;
import @base@.shared.model.CurrentUser;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.gwtplatform.dispatch.rpc.shared.DispatchAsync;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.NoGatekeeper;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;


public class SigninPresenter extends Presenter<SigninPresenter.MyView, SigninPresenter.MyProxy> implements SigninUiHandlers {

    private final EventBus eventBus;
    private final DispatchAsync dispatcher;
    private final PlaceManager placeManager;
    private final AppMessages messages;

    public interface MyView extends View, HasUiHandlers<SigninUiHandlers> {
        String getUsername();
        String getPassword();
        void resetAndFocus();
        void showAlert(String title, String message);
        void hideAlert();
    }

    @ProxyCodeSplit
    @NameToken(NameTokens.signinPage)
    @NoGatekeeper
    public interface MyProxy extends ProxyPlace<SigninPresenter> {
    }

    @Inject
    public SigninPresenter(EventBus eventBus, MyView view, MyProxy proxy, DispatchAsync dispatcher,  PlaceManager placeManager, AppMessages messages) {
        super(eventBus, view, proxy);

        this.dispatcher = dispatcher;
        this.placeManager = placeManager;
        this.eventBus = eventBus;
        this.messages = messages;

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

                PlaceRequest placeRequest = new PlaceRequest.Builder().nameToken(NameTokens.homePage).build();

                getPlaceManager().revealPlace(placeRequest);
            }

            @Override
            public void onFailure(Throwable caught) {
                getView().showAlert(getMessages().authenticationFailedTitle(), getMessages().authenticationFailedMessage());
                getView().resetAndFocus();
                
            }

        });

    }

    private DispatchAsync getDispatcher() {
        return dispatcher;
    }
    
    private PlaceManager getPlaceManager() {
        return placeManager;
    }

    private AppMessages getMessages() {
        return messages;
    }

}
