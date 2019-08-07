package com.nacre.ofo.dto;

import java.io.Serializable;
import java.util.Date;

public class RegisterDto implements Serializable{
	private int registerId;
	private String custFullName;
	private Date dob;
	private String gender;
	private String mobile;
	private String email;
	private LoginDto loginId;
	private AddressDto addressId;	
	
	public int getRegisterId() {
		return registerId;
	}
	public void setRegisterId(int registerId) {
		this.registerId = registerId;
	}
	public LoginDto getLoginId() {
		return loginId;
	}
	public void setLoginId(LoginDto loginId) {
		this.loginId = loginId;
	}
	public AddressDto getAddressId() {
		return addressId;
	}
	public void setAddressId(AddressDto addressId) {
		this.addressId = addressId;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCustFullName() {
		return custFullName;
	}
	public void setCustFullName(String custFullName) {
		this.custFullName = custFullName;
	}
	
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "RegisterDto [registerId=" + registerId + ", custFullName=" + custFullName + ", dob=" + dob + ", gender="
				+ gender + ", mobile=" + mobile + ", email=" + email + ", loginId=" + loginId + ", addressId="
				+ addressId + "]";
	}	
}
