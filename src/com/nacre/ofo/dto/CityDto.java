package com.nacre.ofo.dto;

import java.io.Serializable;

public class CityDto implements Serializable {
	private String cityName;
	private int cityId;
	private StateDto stateId;

	public StateDto getStateId() {
		return stateId;
	}
	public void setStateId(StateDto stateId) {
		this.stateId = stateId;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	@Override
	public String toString() {
		return "CityDto [cityName=" + cityName + ", cityId=" + cityId + ", stateId=" + stateId + "]";
	}
}
