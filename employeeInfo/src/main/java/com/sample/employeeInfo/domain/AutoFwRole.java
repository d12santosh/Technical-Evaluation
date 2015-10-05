package com.sample.employeeInfo.domain;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the AUTO_FW_ROLES database table.
 * 
 */
@Entity
@Table(name="AUTO_FW_ROLES")
@NamedQuery(name="AutoFwRole.findAll", query="SELECT a FROM AutoFwRole a")
public class AutoFwRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="AUTO_FW_ROLES_PK_GENERATOR", sequenceName="AUTO_FW_ROLES_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AUTO_FW_ROLES_PK_GENERATOR")
	@Column(name="AUTO_FW_ROLES_ID", unique=true, nullable=false, precision=10)
	private long autoFwRolesId;

	@Column(name="CREATED_BY", length=50)
	private String createdBy;

	@Column(name="CREATED_DATE")
	private Timestamp createdDate;

	@Column(name="LAST_UPDATED_BY", length=50)
	private String lastUpdatedBy;

	@Column(name="LAST_UPDATED_DATE")
	private Timestamp lastUpdatedDate;

	@Column(name="ROLE_DESCRIPTION", nullable=false, length=100)
	private String roleDescription;

	@Column(name="ROLE_NAME", nullable=false, length=25)
	private String roleName;

	@Column(name="STATUS",nullable=false, precision=1)
	private Integer status;

	//bi-directional many-to-one association to AutoFwUserRole
	@OneToMany(mappedBy="autoFwRole")
	private List<AutoFwUserRole> autoFwUserRoles;

	public AutoFwRole() {
	}

	public long getAutoFwRolesId() {
		return this.autoFwRolesId;
	}

	public void setAutoFwRolesId(long autoFwRolesId) {
		this.autoFwRolesId = autoFwRolesId;
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

	public String getRoleDescription() {
		return this.roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<AutoFwUserRole> getAutoFwUserRoles() {
		return this.autoFwUserRoles;
	}

	public void setAutoFwUserRoles(List<AutoFwUserRole> autoFwUserRoles) {
		this.autoFwUserRoles = autoFwUserRoles;
	}

	public AutoFwUserRole addAutoFwUserRole(AutoFwUserRole autoFwUserRole) {
		getAutoFwUserRoles().add(autoFwUserRole);
		autoFwUserRole.setAutoFwRole(this);

		return autoFwUserRole;
	}

	public AutoFwUserRole removeAutoFwUserRole(AutoFwUserRole autoFwUserRole) {
		getAutoFwUserRoles().remove(autoFwUserRole);
		autoFwUserRole.setAutoFwRole(null);

		return autoFwUserRole;
	}

}