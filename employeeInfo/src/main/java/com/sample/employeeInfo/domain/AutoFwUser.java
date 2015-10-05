package com.sample.employeeInfo.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the AUTO_FW_USERS database table.
 * 
 */
@Entity
@Table(name="AUTO_FW_USERS")
@NamedQuery(name="AutoFwUser.findAll", query="SELECT a FROM AutoFwUser a")
public class AutoFwUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="AUTO_FW_USERS_PK_GENERATOR", sequenceName="AUTO_FW_USERS_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AUTO_FW_USERS_PK_GENERATOR")
	@Column(name="AUTO_FW_USERS_ID", unique=true, nullable=false, precision=10)
	private long autoFwUsersId;

	@Column(name="CREATED_BY", length=50)
	private String createdBy;

	@Column(name="CREATED_DATE")
	private Timestamp createdDate;

	@Column(name="EMAIL",nullable=false, length=50)
	private String email;

	@Column(name="FIRST_NAME", nullable=false, length=50)
	private String firstName;

	@Column(name="LAST_NAME", nullable=false, length=100)
	private String lastName;

	@Column(name="LAST_UPDATED_BY", length=50)
	private String lastUpdatedBy;

	@Column(name="LAST_UPDATED_DATE")
	private Timestamp lastUpdatedDate;

	@Column(name="LOGIN_ID", nullable=false, length=20)
	private String loginId;

	@Column(name="PASSWORD",nullable=false, length=15)
	private String password;

	@Column(name="USER_ACCOUNT_STATUS", nullable=false, precision=1)
	private BigDecimal userAccountStatus;

	//bi-directional many-to-one association to AutoFwUserRole
	@OneToMany(mappedBy="autoFwUser")
	private List<AutoFwUserRole> autoFwUserRoles;

	public AutoFwUser() {
	}

	public long getAutoFwUsersId() {
		return this.autoFwUsersId;
	}

	public void setAutoFwUsersId(long autoFwUsersId) {
		this.autoFwUsersId = autoFwUsersId;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastUpdatedBy() {
		return this.lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Timestamp getLastUpdatedDate() {
		return this.lastUpdatedDate;
	}

	public void setLastUpdatedDate(Timestamp lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getLoginId() {
		return this.loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BigDecimal getUserAccountStatus() {
		return this.userAccountStatus;
	}

	public void setUserAccountStatus(BigDecimal userAccountStatus) {
		this.userAccountStatus = userAccountStatus;
	}

	public List<AutoFwUserRole> getAutoFwUserRoles() {
		return this.autoFwUserRoles;
	}

	public void setAutoFwUserRoles(List<AutoFwUserRole> autoFwUserRoles) {
		this.autoFwUserRoles = autoFwUserRoles;
	}

	public AutoFwUserRole addAutoFwUserRole(AutoFwUserRole autoFwUserRole) {
		getAutoFwUserRoles().add(autoFwUserRole);
		autoFwUserRole.setAutoFwUser(this);

		return autoFwUserRole;
	}

	public AutoFwUserRole removeAutoFwUserRole(AutoFwUserRole autoFwUserRole) {
		getAutoFwUserRoles().remove(autoFwUserRole);
		autoFwUserRole.setAutoFwUser(null);

		return autoFwUserRole;
	}

}