package com.sample.employeeInfo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sample.employeeInfo.DAO.IUserDAO;
import com.sample.employeeInfo.bean.EmployeeBean;
import com.sample.employeeInfo.domain.AutoFwUser;
import com.sample.employeeInfo.service.IEmployeeService;


@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	IUserDAO userDAO;
	
	@Override
	@Transactional
	public EmployeeBean addEmployee(EmployeeBean employee) {
		AutoFwUser autoFwUser = populateDTO(employee);
		userDAO.saveUser(autoFwUser);
		employee.setEmployeeID(autoFwUser.getAutoFwUsersId());
		return employee;
	}

	private AutoFwUser populateDTO(EmployeeBean employee) {
		AutoFwUser autoFwUser = new AutoFwUser();
		autoFwUser.setFirstName(employee.getFirstName());
		autoFwUser.setLastName(employee.getLastName());
		autoFwUser.setEmail(employee.getEmailID());
		autoFwUser.setLoginId(employee.getEmailID());
		return autoFwUser;
	}

	@Override
	@Transactional
	public void deleteEmployee(EmployeeBean employee) {
		AutoFwUser autoFwUser = populateDTO(employee);
		 userDAO.deleteUser(autoFwUser);
	}

	@Override
	@Transactional
	public void updateEmployee(EmployeeBean employee) {
		AutoFwUser autoFwUser = populateDTO(employee);
		 userDAO.updateUser(autoFwUser);
	}

	

	
	
}
