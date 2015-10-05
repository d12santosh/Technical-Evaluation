package com.sample.employeeInfo.service;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.sample.employeeInfo.BaseSpringTestConfiguration;
import com.sample.employeeInfo.bean.EmployeeBean;

public class EmployeeServiceTest extends BaseSpringTestConfiguration{

	@Autowired
	IEmployeeService employeeService;
	
	@Test
	@Transactional
	@Rollback
	public void testAddEmployee(){
		EmployeeBean employee = getBeanWithDefaultProperties();
		 employeeService.addEmployee(employee);
		 Assert.assertTrue(employee.getEmployeeID()>0);
	}

	private EmployeeBean getBeanWithDefaultProperties() {
		EmployeeBean employee = new EmployeeBean();
		employee.setEmailID("sample@sampleTest.com");
		employee.setFirstName("Sample");
		employee.setLastName("Test");
		return employee;
	}
		
	
}
