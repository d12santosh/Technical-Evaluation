package com.sample.employeeInfo.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the AUTO_FW_USER_ROLE database table.
 * 
 */
@Entity
@Table(name="AUTO_FW_USER_ROLE")
@NamedQuery(name="AutoFwUserRole.findAll", query="SELECT a FROM AutoFwUserRole a")
public class AutoFwUserRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="AUTO_FW_USER_ROLE_PK_GENERATOR", sequenceName="AUTO_FW_USER_ROLE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AUTO_FW_USER_ROLE_PK_GENERATOR")
	@Column(name="AUTO_FW_USER_ROLE_ID", unique=true, nullable=false, precision=10)
	private long autoFwUserRoleId;

	@Column(name="CREATED_BY", length=50)
	private String createdBy;

	@Column(name="CREATED_DATE")
	private Timestamp createdDate;

	@Column(name="LAST_UPDATED_BY", length=50)
	private String lastUpdatedBy;

	@Column(name="LAST_UPDATED_DATE")
	private Timestamp lastUpdatedDate;

	//bi-directional many-to-one association to AutoFwRole
	@ManyToOne
	@JoinColumn(name="AUTO_FW_ROLES_ID", nullable=false)
	private AutoFwRole autoFwRole;

	//bi-directional many-to-one association to AutoFwUser
	@ManyToOne
	@JoinColumn(name="AUTO_FW_USERS_ID", nullable=false)
	private AutoFwUser autoFwUser;

	public AutoFwUserRole() {
	}

	public long getAutoFwUserRoleId() {
		return this.autoFwUserRoleId;
	}

	public void setAutoFwUserRoleId(long autoFwUserRoleId) {
		this.autoFwUserRoleId = autoFwUserRoleId;
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

	public AutoFwRole getAutoFwRole() {
		return this.autoFwRole;
	}

	public void setAutoFwRole(AutoFwRole autoFwRole) {
		this.autoFwRole = autoFwRole;
	}

	public AutoFwUser getAutoFwUser() {
		return this.autoFwUser;
	}

	public void setAutoFwUser(AutoFwUser autoFwUser) {
		this.autoFwUser = autoFwUser;
	}

}