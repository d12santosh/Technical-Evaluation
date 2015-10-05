package com.sample.employeeInfo.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sample.employeeInfo.DAO.IUserDAO;
import com.sample.employeeInfo.domain.AutoFwUser;
import com.sample.employeeInfo.domain.AutoFwUserRole;




@Service
@Transactional(readOnly=true)
public class EmpUserDetailsService implements UserDetailsService {

	@Autowired
    private IUserDAO userDAO; 
	
	@Override
	public UserDetails loadUserByUsername(String login)
			throws UsernameNotFoundException {

		AutoFwUser domainUser = userDAO.getUser(login);
		
		 boolean enabled = true;
	        boolean accountNonExpired = true;
	        boolean credentialsNonExpired = true;
	        boolean accountNonLocked = true;
	        
	        
	        return new org.springframework.security.core.userdetails.User(
	                domainUser.getLoginId(),
	                domainUser.getPassword(),
	                enabled,
	                accountNonExpired,
	                credentialsNonExpired,
	                accountNonLocked,
	                getAuthorities(domainUser.getAutoFwUserRoles())
	            );
	}
	
	
	 public Collection<? extends GrantedAuthority> getAuthorities(List<AutoFwUserRole> rolesList) {
	        List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(rolesList));
	        return authList;
	    }
	 
	 public List<String> getRoles(List<AutoFwUserRole> rolesList) {

	        List<String> roles = new ArrayList<String>();

	        for (AutoFwUserRole role : rolesList) {
				
	        if (role.getAutoFwRole().getAutoFwRolesId() == 1) {
	            roles.add("ROLE_ADMIN");
	            roles.add("ROLE_MODERATOR");
	        } else if (role.getAutoFwRole().getAutoFwRolesId() == 2) {
	            roles.add("ROLE_MODERATOR");
	        }
	        }
	        return roles;
	    }
	
	public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
       
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }

}
