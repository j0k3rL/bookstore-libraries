package com.bookstore.libraries.jpa;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.bookstore.libraries.exception.DAOException;
import com.bookstore.libraries.exception.ObjectNotFoundDAOException;

public abstract class AbstractDAO<T extends AbstractEntity> {

	@PersistenceContext
	private EntityManager em;

	private Class<T> entityClass;

	@SuppressWarnings("unchecked")
	public AbstractDAO() {

		try {
        	
        	String clazz = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0].getTypeName();
        	entityClass = (Class<T>) Class.forName(clazz);
		
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException();
        }
	}

	public Collection<T> listAll() throws DAOException {

		try {

			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<T> cq = cb.createQuery(entityClass);
			
			Root<T> rootEntry = cq.from(entityClass);
			CriteriaQuery<T> all = cq.select(rootEntry);
			
			TypedQuery<T> allQuery = em.createQuery(all);
			List<T> list = allQuery.getResultList();

			if (list == null || list.isEmpty()) {
				throw new ObjectNotFoundDAOException();
			}

			return list;
			
		} catch (RuntimeException e) {
			throw new DAOException(e);
		}
	}

	public T findById(Long id) throws DAOException {

		try {
			return em.find(entityClass, id);
		} catch (NoResultException e) {
			throw new ObjectNotFoundDAOException(e);
		} catch (RuntimeException e) {
			throw new DAOException(e);
		}
	}

	public boolean existById(Long id) throws DAOException {
		
		try {
			
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<T> cq = cb.createQuery(entityClass);
			
			Root<T> rootEntry = cq.from(entityClass);
			cq.where(cb.equal(rootEntry.get("id"), id));
			
			CriteriaQuery<T> exist = cq.select(rootEntry);
			TypedQuery<T> existQuery = em.createQuery(exist);
			
			existQuery.setMaxResults(1);
			Object obj = existQuery.getSingleResult();
			
			return obj != null;
		} catch (NoResultException e) {
			return false;
		} catch (RuntimeException e) {
			throw new DAOException(e);
		}
	}
	
	public final void insert(T entity) throws DAOException {

		try {
			em.persist(entity);
		} catch (RuntimeException e) {
			throw new DAOException(e);
		}
	}

	public T update(T entity) throws DAOException {

		try {
			return (T) em.merge(entity);
		} catch (RuntimeException e) {
			throw new DAOException(e);
		}
	}

	public final void delete(T entity) throws DAOException {

		try {
			em.remove(em.merge(entity));
		} catch (RuntimeException e) {
			throw new DAOException(e);
		}
	}
}