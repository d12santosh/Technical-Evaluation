package com.sample.employeeInfo.service;

import com.sample.employeeInfo.bean.EmployeeBean;
import com.sample.employeeInfo.domain.AutoFwUser;

public interface IEmployeeService {

	public EmployeeBean addEmployee(EmployeeBean employee);
	public void deleteEmployee(EmployeeBean employee);
	public void updateEmployee(EmployeeBean employee);
	
	
}
