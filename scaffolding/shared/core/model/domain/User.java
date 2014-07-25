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

@javax.persistence.Entity
@javax.persistence.Table(name = "TB_User")
@javax.persistence.Cacheable(true)
@lombok.Data
@lombok.EqualsAndHashCode(of = { "username" })
public class User implements java.io.Serializable, Auditable {

	private static final long serialVersionUID = 1L;

	@javax.persistence.Column(name = "C_username", nullable = false, updatable = true, insertable = true)
	private java.lang.String username;

	@javax.persistence.Column(name = "C_password", nullable = false, updatable = true, insertable = true)
	private java.lang.String password;

	@javax.persistence.Column(name = "C_salt", nullable = false, updatable = true, insertable = true)
	private java.lang.String salt;

	@javax.persistence.Column(name = "id", updatable = true, insertable = true)
	@javax.persistence.Id
	@javax.persistence.TableGenerator(name = "UserPKGen", table = "PERSISTENCE_ORDER_SEQUENCE_GENERATOR", pkColumnName = "GEN_KEY", valueColumnName = "GEN_VALUE", pkColumnValue = "USER_ID", allocationSize = 10)
	@javax.persistence.GeneratedValue(generator = "UserPKGen")
	private java.lang.Long id;

	@javax.persistence.Column(name = "C_creationDate", nullable = false, updatable = false, insertable = true)
	private java.util.Date creationDate;

	@javax.persistence.Column(name = "C_creationeUser", length = 50, nullable = false, updatable = false, insertable = true)
	private java.lang.String creationUser;

	@javax.persistence.Column(name = "C_modificationDate", nullable = false, updatable = true, insertable = true)
	private java.util.Date modificationDate;

	@javax.persistence.Column(name = "C_modificationUser", length = 50, nullable = false, updatable = true, insertable = true)
	private java.lang.String modificationUser;

}
