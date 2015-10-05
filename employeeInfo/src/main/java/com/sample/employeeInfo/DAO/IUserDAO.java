package com.sample.employeeInfo.DAO;

import com.sample.employeeInfo.domain.AutoFwUser;





public interface IUserDAO {
	
	public AutoFwUser getUser(String login);
}
