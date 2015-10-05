package com.sample.employeeInfo.DAO.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.sample.employeeInfo.DAO.DaoBase;
import com.sample.employeeInfo.DAO.IRoleDAO;
import com.sample.employeeInfo.domain.AutoFwRole;


@Repository
public class RoleDAOImpl extends DaoBase implements IRoleDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public AutoFwRole getRole(int id) {
		AutoFwRole role = (AutoFwRole) entityManager.find(AutoFwRole.class, id);
        return role;
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
		}

}
