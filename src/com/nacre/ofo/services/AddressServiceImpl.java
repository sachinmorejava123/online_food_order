package com.nacre.ofo.services;

import java.sql.SQLException;
import java.util.List;

import com.nacre.ofo.dao.AddressDAOI;
import com.nacre.ofo.dao.AddressDAOImpl;
import com.nacre.ofo.dto.CityDto;
import com.nacre.ofo.dto.CountryDto;
import com.nacre.ofo.dto.StateDto;

public class AddressServiceImpl implements AddressServiceI {

	@Override
	public List<CountryDto> CountryService() throws SQLException {
		AddressDAOI addressDAOI=new AddressDAOImpl();
		List l=addressDAOI.getCountry();
		return l;
	}

	@Override
	public List<StateDto> StateService(int cid) throws SQLException {
		AddressDAOI addressDAOI=new AddressDAOImpl();
		List l=addressDAOI.getStateDAO(cid);
		return l;
	}

	@Override
	public List<CityDto> CityService(int cityid) throws SQLException {
		AddressDAOI addressDAOI=new AddressDAOImpl();
		List l=addressDAOI.getCityDAO(cityid);
		return l;
	}

}
