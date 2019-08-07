package com.nacre.ofo.services;

import java.sql.SQLException;
import java.util.List;

import com.nacre.ofo.dto.AddressDto;
import com.nacre.ofo.dto.CityDto;
import com.nacre.ofo.dto.CountryDto;
import com.nacre.ofo.dto.LoginDto;
import com.nacre.ofo.dto.StateDto;

public interface AddressServiceI {
	public List<CountryDto> CountryService() throws SQLException;
	public List<StateDto> StateService(int sid) throws SQLException;
	public List<CityDto> CityService(int cityid) throws SQLException;
	
}
