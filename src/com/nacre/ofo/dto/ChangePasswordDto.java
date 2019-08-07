package com.nacre.ofo.dto;

import java.io.Serializable;

public class ChangePasswordDto implements Serializable{
	private String username;
	private String oldPassword;
	private String newPassword;
	private String reNewPassword;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getReNewPassword() {
		return reNewPassword;
	}
	public void setReNewPassword(String reNewPassword) {
		this.reNewPassword = reNewPassword;
	}
	@Override
	public String toString() {
		return "ChangePasswordDto [username=" + username + ", oldPassword=" + oldPassword + ", newPassword="
				+ newPassword + ", reNewPassword=" + reNewPassword + "]";
	}
}
