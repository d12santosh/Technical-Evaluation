package com.sample.employeeInfo.DAO;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class DaoBase {
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public <T> List<T> list(Class<T> clz) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> cri = cb.createQuery(clz);
		cri.from(clz);
		Query query = entityManager.createQuery(cri);
		return query.getResultList();
	}
	

	@Transactional(readOnly=true)
	public <T> List<T> list(Class<T> clz, int index, int pageSize) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> cri = cb.createQuery(clz);
		cri.from(clz);
		
		TypedQuery<T> query = entityManager.createQuery(cri);
		query.setFirstResult(index);
		query.setMaxResults(pageSize);
		return query.getResultList();
	}
	
	@Transactional(readOnly=true)
	public <T> int sizeOf(Class<T> clz) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> cri = cb.createQuery(Long.class);
		cri.select(cb.count(cri.from(clz)));
		
		TypedQuery<Long> query = entityManager.createQuery(cri);
		return query.getSingleResult().intValue();//TODO what is data is much?
	}
	 
    @Transactional
    public <T> T update(T item){
    	item = entityManager.merge(item);
        return item;
    }
    
    @Transactional
    public <T> T persist(T item){
    	entityManager.persist(item);
        return item;
    }
    
    @Transactional
    public <T> T refresh(T item){
    	entityManager.refresh(item);
        return item;
    }
    
    @Transactional
    public <T> void delete(T item){
    	 entityManager.remove(item);
       }
    
    @Transactional
    public <T> T reload(Class<T> clz, Serializable key){
    	return entityManager.find(clz, key);
    }
    
    
	
}
