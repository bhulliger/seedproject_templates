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

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.fusesource.restygwt.client.Options;
import org.fusesource.restygwt.client.RestService;

import @base@.shared.model.UserDto;

@Options(dispatcher = AuthenticationDispatcher.class)
@Path("/rest/basic")
public interface BasicRestClient extends RestService {

	@GET
	@Path("/v1/user")
	@Produces(MediaType.APPLICATION_JSON)
	@Options(expect = HttpConstants.STATUS_OK)
	void getUser(AbstractRestCallback<UserDto> user);
	
}