package @package@;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.security.DenyAll;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import com.mysema.query.jpa.impl.JPAQuery;

import @base@.model.domain.Auditable;


public abstract class BaseDao<T extends Auditable> {
	
	private final Class<T> persistentClass;

	@PersistenceContext
	private EntityManager em;

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