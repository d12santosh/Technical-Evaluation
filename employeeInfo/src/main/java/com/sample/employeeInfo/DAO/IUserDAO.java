package com.sample.employeeInfo.DAO;

import com.sample.employeeInfo.domain.AutoFwUser;





public interface IUserDAO {
	
	public AutoFwUser getUser(String login);
	public AutoFwUser saveUser(AutoFwUser user);

	public AutoFwUser updateUser(AutoFwUser user);
	public void deleteUser(AutoFwUser user);
	
}
