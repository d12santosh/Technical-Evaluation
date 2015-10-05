package com.sample.employeeInfo.DAO.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sample.employeeInfo.DAO.DaoBase;
import com.sample.employeeInfo.DAO.IUserDAO;
import com.sample.employeeInfo.domain.AutoFwUser;

@Repository
public class UserDAOImpl extends DaoBase implements IUserDAO {

	@Autowired
	DaoBase baseDAO;
	
	@Override
	@Transactional
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

	@Override
	@Transactional
	public AutoFwUser saveUser(AutoFwUser user) {
		
		return baseDAO.persist(user);
	}

	@Override
	public AutoFwUser updateUser(AutoFwUser user) {
		baseDAO.update(user);
		return user;
	}

	@Override
	public void deleteUser(AutoFwUser user) {
		baseDAO.delete(user);
		
	}

	

}
