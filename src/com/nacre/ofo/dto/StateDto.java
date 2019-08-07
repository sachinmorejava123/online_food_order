package com.nacre.ofo.dto;

import java.io.Serializable;

public class StateDto implements Serializable {
	private String stateName;
	private int stateId;
	private CountryDto countryId;
	
	public CountryDto getCountryId() {
		return countryId;
	}
	public void setCountryId(CountryDto countryId) {
		this.countryId = countryId;
	}
	public int getStateId() {
		return stateId;
	}
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	@Override
	public String toString() {
		return "StateDto [stateName=" + stateName + ", stateId=" + stateId + ", countryId=" + countryId + "]";
	}
}
