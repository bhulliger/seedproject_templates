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

import java.io.Serializable;
import java.util.List;

public class CurrentUser implements Serializable {

	private static final long serialVersionUID = 1L;

	private String username;

	private List<String> roles;

	private boolean authenticated = true;

	public CurrentUser(final String username) {
		this.username = username;
	}

	public List<String> getRoles() {
		return this.roles;
	}

	public String getUsername() {
		return this.username;
	}

	public boolean isAdmin() {
		return roles != null && roles.contains("ROLE_ADMIN");
	}

	public boolean isAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(final boolean authenticated) {
		this.authenticated = authenticated;
	}

	public void setRoles(final List<String> roles) {
		this.roles = roles;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

}