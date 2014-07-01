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

import @base@.client.application.ApplicationModule;
import @base@.client.place.NameTokens;
import @base@.client.ws.BasicRestClient;

import @base@.client.gatekeeper.AdminGatekeeper;
import @base@.client.gatekeeper.UserGatekeeper;
import @base@.shared.model.CurrentUser;

import com.google.gwt.core.client.GWT;
import com.google.inject.Provides;
import com.google.inject.Singleton;
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
        
        // Constants
        bindConstant().annotatedWith(DefaultPlace.class).to(NameTokens.homePage);
        bindConstant().annotatedWith(ErrorPlace.class).to(NameTokens.homePage);
        bindConstant().annotatedWith(UnauthorizedPlace.class).to(NameTokens.homePage);

        // Gatekeepers
        bind(CurrentUser.class).in(Singleton.class);
        bind(AdminGatekeeper.class).in(Singleton.class);
        bind(UserGatekeeper.class).in(Singleton.class);
        
        // Presenters
        install(new ApplicationModule());

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
