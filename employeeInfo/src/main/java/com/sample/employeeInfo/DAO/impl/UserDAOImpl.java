package com.sample.employeeInfo.DAO.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sample.employeeInfo.DAO.IUserDAO;
import com.sample.employeeInfo.domain.AutoFwUser;

@Repository
public class UserDAOImpl implements IUserDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	public AutoFwUser getUser(String login) {
		
		List<AutoFwUser> userList = new ArrayList<AutoFwUser>();
        Query query = getEntityManager().createQuery("from AutoFwUser u where u.loginId = :login");
        query.setParameter("login", login);
        userList = query.getResultList();
        if (userList.size() > 0)
            return userList.get(0);
        else
            return null;   
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
