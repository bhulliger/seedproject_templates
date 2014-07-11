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

import @base@.client.event.LoginAuthenticatedEvent;
import @base@.client.event.LoginAuthenticatedEvent.LoginAuthenticatedHandler;
import @base@.shared.model.CurrentUser;

import com.google.gwt.event.shared.EventBus;
import com.gwtplatform.mvp.client.proxy.Gatekeeper;

public abstract class AbstractGatekeeper implements Gatekeeper {

	private final EventBus eventBus;

	private CurrentUser currentUser;

	public AbstractGatekeeper(final EventBus eventBus) {
		this.eventBus = eventBus;

		this.eventBus.addHandler(LoginAuthenticatedEvent.getType(), new LoginAuthenticatedHandler() {
			@Override
			public void onLoginAuthenticated(final LoginAuthenticatedEvent event) {
				currentUser = event.getCurrentUser();
			}
		});
		
	}

	protected CurrentUser getCurrentUser() {
		return currentUser;
	}
}