package com.nacre.ofo.dao;

import java.sql.SQLException;
import java.util.List;

import com.nacre.ofo.dto.AddressDto;
import com.nacre.ofo.dto.CityDto;
import com.nacre.ofo.dto.CountryDto;
import com.nacre.ofo.dto.StateDto;

public interface NotificationDAOI {	
	public int getOrdersCount() throws SQLException;
}
