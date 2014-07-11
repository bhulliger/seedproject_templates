/**
 * Copyright 2014 Brigitte Hulliger
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

import org.gwtbootstrap3.client.ui.constants.AlertType;

import @base@.client.event.LoginAuthenticatedEvent;
import @base@.client.i18n.AppMessages;
import @base@.client.place.NameTokens;
import @base@.shared.action.LoginAction;
import @base@.shared.action.LoginResult;
import @base@.shared.model.CurrentUser;

import com.google.gwt.event.shared.HasHandlers;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rpc.shared.DispatchAsync;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.NoGatekeeper;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;

public class SigninPresenter extends Presenter<SigninPresenter.MyView, SigninPresenter.MyProxy> implements
        SigninUiHandlers {
    @ProxyStandard
    @NameToken(NameTokens.signinPage)
    @NoGatekeeper
    public interface MyProxy extends ProxyPlace<SigninPresenter> {
    }

    public interface MyView extends View, HasUiHandlers<SigninUiHandlers> {
        String getUsername();

        String getPassword();

        void resetAndFocus();

        void showAlert(final String title, final String message, AlertType type);

        void hideAlert();
    }

    private final EventBus eventBus;

    private final DispatchAsync dispatcher;

    private final PlaceManager placeManager;

    private final AppMessages messages;

    @Inject
    public SigninPresenter(final EventBus eventBus, final MyView view, final MyProxy proxy,
            final DispatchAsync dispatcher, final PlaceManager placeManager, final AppMessages messages) {
        super(eventBus, view, proxy, RevealType.Root);

        this.dispatcher = dispatcher;
        this.placeManager = placeManager;
        this.eventBus = eventBus;
        this.messages = messages;

        view.setUiHandlers(this);
    }

    private void authenticate(final String username, final String password) {
        getDispatcher().execute(new LoginAction(username, password), new AsyncCallback<LoginResult>() {

            @Override
            public void onFailure(final Throwable caught) {
                getView().showAlert(getMessages().authenticationFailedTitle(),
                        getMessages().authenticationFailedMessage(), AlertType.DANGER);
                getView().resetAndFocus();

            }

            @Override
            public void onSuccess(final LoginResult result) {
                final CurrentUser currentUser = new CurrentUser(getView().getUsername());

                LoginAuthenticatedEvent.fire((HasHandlers) eventBus, currentUser);

                final PlaceRequest placeRequest = new PlaceRequest.Builder().nameToken(NameTokens.homePage).build();

                getPlaceManager().revealPlace(placeRequest);
            }

        });

    }

    private DispatchAsync getDispatcher() {
        return dispatcher;
    }

    private AppMessages getMessages() {
        return messages;
    }

    private PlaceManager getPlaceManager() {
        return placeManager;
    }

    @Override
    public void onSignin() {
        authenticate(getView().getUsername(), getView().getPassword());
    }

}
