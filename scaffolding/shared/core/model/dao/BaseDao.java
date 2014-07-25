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
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.security.DenyAll;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import @base@.model.domain.Auditable;

public abstract class BaseDao<T extends Auditable> {
	
	private final Class<T> persistentClass;

	@PersistenceContext
	protected EntityManager em;

	@SuppressWarnings("unchecked")
	public BaseDao() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@DenyAll
	public T create(T entity) {
		return em.merge(entity);
	}

	@DenyAll
	public void delete(T entity) {
		em.remove(entity);
	}

	@DenyAll
	public T read(Serializable id) {
		return em.find(this.persistentClass, id);
	}

	@DenyAll
	public T update(T entity) {
		return em.merge(entity);
	}

	@DenyAll
	public List<T> readAll() {
		// TODO Auto-generated method stub
		 return null;
	}

}