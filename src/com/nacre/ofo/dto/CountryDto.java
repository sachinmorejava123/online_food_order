package com.nacre.ofo.dto;

import java.io.Serializable;

public class CountryDto implements Serializable {
	private String countryName;
	private int cid;

	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
	@Override
	public String toString() {
		return "CountryDto [countryName=" + countryName + ", cid=" + cid + "]";
	}
	
	
	
}
