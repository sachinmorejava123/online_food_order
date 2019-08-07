package com.nacre.ofo.dao;

import java.sql.SQLException;
import java.util.List;

import com.nacre.ofo.dto.AddressDto;
import com.nacre.ofo.dto.CityDto;
import com.nacre.ofo.dto.CountryDto;
import com.nacre.ofo.dto.StateDto;

public interface AddressDAOI {	
	public List<CountryDto> getCountry() throws SQLException;
	public List<StateDto> getStateDAO(int cid) throws SQLException;
	public List<CityDto> getCityDAO(int cityid) throws SQLException;
}
