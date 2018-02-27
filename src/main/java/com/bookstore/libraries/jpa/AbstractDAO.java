package com.bookstore.libraries.jpa;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;

import com.bookstore.libraries.BookstoreConstants;
import com.bookstore.libraries.exception.DAOException;
import com.bookstore.libraries.exception.NonUniqueResultDAOException;
import com.bookstore.libraries.exception.ObjectNotFoundDAOException;

public abstract class AbstractDAO<T extends AbstractEntity> implements BookstoreConstants {

	protected static Logger logger;

	@PersistenceContext
	private EntityManager em;

	private Class<T> entityClass;

	@SuppressWarnings("unchecked")
	public AbstractDAO() {

		try {
			
			String clazz = ((ParameterizedType) getClass()
					.getGenericSuperclass())
					.getActualTypeArguments()[0]
					.getTypeName();
		
			entityClass = (Class<T>) Class.forName(clazz);
		
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException();
		}
	}
	
	@PostConstruct
	private void init() {
		logger = Logger.getLogger(this.getClass());
	}

	protected final EntityManager getEntityManager() {
		return em;
	}
	
	protected final String toLike(String string) {
        return '%' + string + '%';
    }
	
	protected final Query createQuery(String qlString) {
        return createQuery(qlString, true);
    }
	
	protected final Query createQuery(String qlString, boolean limited) {
        Query q = getEntityManager().createQuery(qlString);
        if (limited) q.setMaxResults(1000);

        return q;
    }
	
	protected TypedQuery<T> createNamedQuery(String name, Class<T> entity) {
		return getEntityManager().createNamedQuery(name, entity);
	}
	
	public Collection<T> listAll() throws DAOException {

		try {

			CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
			CriteriaQuery<T> cq = cb.createQuery(entityClass);

			Root<T> rootEntry = cq.from(entityClass);
			CriteriaQuery<T> all = cq.select(rootEntry);

			TypedQuery<T> allQuery = getEntityManager().createQuery(all);
			List<T> list = getResultList(allQuery);

			return list;

		} catch (RuntimeException e) {
			throw new DAOException(e);
		}
	}

	public T findById(Long id) throws DAOException {

		try {
			return getEntityManager().find(entityClass, id);
		} catch (NoResultException e) {
			throw new ObjectNotFoundDAOException(e);
		} catch (RuntimeException e) {
			throw new DAOException(e);
		}
	}

	public boolean existById(Long id) throws DAOException {

		try {

			CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
			CriteriaQuery<T> cq = cb.createQuery(entityClass);

			Root<T> rootEntry = cq.from(entityClass);
			cq.where(cb.equal(rootEntry.get("id"), id));

			CriteriaQuery<T> exist = cq.select(rootEntry);
			TypedQuery<T> existQuery = getEntityManager().createQuery(exist);

			existQuery.setMaxResults(1);
			Object obj = getSingleResult(existQuery);

			return obj != null;
			
		} catch (ObjectNotFoundDAOException e) {
			return false;
		} catch (RuntimeException e) {
			throw new DAOException(e);
		}
	}

	public final void insert(T entity) throws DAOException {

		try {
			getEntityManager().persist(entity);
		} catch (RuntimeException e) {
			throw new DAOException(e);
		}
	}

	public T update(T entity) throws DAOException {

		try {
			return (T) getEntityManager().merge(entity);
		} catch (RuntimeException e) {
			throw new DAOException(e);
		}
	}

	public final void delete(T entity) throws DAOException {

		try {
			getEntityManager().remove(getEntityManager().merge(entity));
		} catch (RuntimeException e) {
			throw new DAOException(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	protected T getSingleResult(Query query) throws ObjectNotFoundDAOException, NonUniqueResultDAOException {
    	
		try {
			return (T) query.getSingleResult();
    	} catch (NoResultException e) {
    		throw new ObjectNotFoundDAOException(e);
		} catch (NonUniqueResultException e) {
            throw new NonUniqueResultDAOException(e);
        }
    }
	
	@SuppressWarnings("unchecked")
	protected List<T> getResultList(Query query) throws ObjectNotFoundDAOException {
		
		List<T> resultList = query.getResultList();
		if (resultList == null || resultList.isEmpty()) {
			throw new ObjectNotFoundDAOException();
		}
		
		return resultList;
    }
}