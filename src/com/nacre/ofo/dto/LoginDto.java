package com.nacre.ofo.dto;

import java.io.Serializable;

public class LoginDto implements Serializable{
	private int loginId;
	private String username;
	private String otp;
	private String password;
	private RoleDto roleId;	
	private int reg_Id;
	private int countNewOrderLogin;
	
	public int getCountNewOrderLogin() {
		return countNewOrderLogin;
	}
	public void setCountNewOrderLogin(int countNewOrderLogin) {
		this.countNewOrderLogin = countNewOrderLogin;
	}
	public int getReg_Id() {
		return reg_Id;
	}
	public void setReg_Id(int reg_Id) {
		this.reg_Id = reg_Id;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public int getLoginId() {
		return loginId;
	}
	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}
	public RoleDto getRoleId() {
		return roleId;
	}
	public void setRoleId(RoleDto roleId) {
		this.roleId = roleId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	} 
	
	@Override
	public String toString() {
		return "LoginDto [loginId=" + loginId + ", username=" + username + ", otp=" + otp + ", password=" + password
				+ ", roleId=" + roleId + ", reg_Id=" + reg_Id + ", countNewOrderLogin=" + countNewOrderLogin + "]";
	}
}
