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

import org.fusesource.restygwt.client.Resource;
import org.fusesource.restygwt.client.RestServiceProxy;

import @base@.client.application.ApplicationPresenter;
import @base@.client.application.ApplicationView;
import @base@.client.application.home.HomePresenter;
import @base@.client.application.home.HomeView;
import @base@.client.application.profile.ProfilePresenter;
import @base@.client.application.profile.ProfileView;
import @base@.client.application.signin.SigninPresenter;
import @base@.client.application.signin.SigninView;
import @base@.client.application.ui.UiModule;
import @base@.client.gatekeeper.AdminGatekeeper;
import @base@.client.gatekeeper.UserGatekeeper;
import @base@.client.place.NameTokens;
import @base@.client.ws.BasicRestClient;

import com.google.gwt.core.client.GWT;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.gwtplatform.dispatch.rpc.client.gin.RpcDispatchAsyncModule;
import com.gwtplatform.mvp.client.annotations.DefaultPlace;
import com.gwtplatform.mvp.client.annotations.ErrorPlace;
import com.gwtplatform.mvp.client.annotations.UnauthorizedPlace;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;
import com.gwtplatform.mvp.client.proxy.DefaultPlaceManager;

/**
 * See more on setting up the PlaceManager on <a
 * href="// See more on: https://github.com/ArcBees/GWTP/wiki/PlaceManager">DefaultModule's > DefaultPlaceManager</a>
 */
public class ClientModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        
    	// Singletons -  DefaultModule initializes the DefaultPlaceManager
        install(new DefaultModule(DefaultPlaceManager.class));
        install(new RpcDispatchAsyncModule());

        // Header & Footer
        install(new UiModule());

        // Constants
        bindConstant().annotatedWith(DefaultPlace.class).to(NameTokens.homePage);
        bindConstant().annotatedWith(ErrorPlace.class).to(NameTokens.homePage);
        bindConstant().annotatedWith(UnauthorizedPlace.class).to(NameTokens.homePage);

        // Gatekeepers
        // bind(AdminGatekeeper.class).in(Singleton.class);
        // bind(UserGatekeeper.class).in(Singleton.class);
        
        // Presenters
        bindPresenter(ApplicationPresenter.class, ApplicationPresenter.MyView.class, ApplicationView.class, ApplicationPresenter.MyProxy.class);
        bindPresenter(SigninPresenter.class, SigninPresenter.MyView.class, SigninView.class, SigninPresenter.MyProxy.class);
        bindPresenter(HomePresenter.class, HomePresenter.MyView.class, HomeView.class, HomePresenter.MyProxy.class);
        bindPresenter(ProfilePresenter.class, ProfilePresenter.MyView.class, ProfileView.class, ProfilePresenter.MyProxy.class);

        // Load and inject CSS Resources
        bind(ResourceLoader.class).asEagerSingleton();
    }

    @Singleton
    @Provides
    public BasicRestClient getBasicRestClient() {
        Resource resource = new Resource(GWT.getHostPageBaseURL());
        BasicRestClient proxy = GWT.create(BasicRestClient.class);
        ((RestServiceProxy) proxy).setResource(resource);
        return proxy;
    }
}
