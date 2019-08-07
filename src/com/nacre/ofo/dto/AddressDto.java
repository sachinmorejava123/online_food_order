package com.nacre.ofo.dto;

import java.io.Serializable;

public class AddressDto implements Serializable {
	private String address;
	private int pincode ;
	private CityDto cityId;
	
	public CityDto getCityId() {
		return cityId;
	}
	public void setCityId(CityDto cityId) {
		this.cityId = cityId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "AddressDto [address=" + address + ", pincode=" + pincode + ", cityId=" + cityId + "]";
	}
}
