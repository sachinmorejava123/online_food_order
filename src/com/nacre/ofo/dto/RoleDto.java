package com.nacre.ofo.dto;

import java.io.Serializable;

public class RoleDto implements Serializable{
	private String roleName;
	private int roleId;
	
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	@Override
	public String toString() {
		return "RoleDto [roleName=" + roleName + ", roleId=" + roleId + "]";
	}	
}
