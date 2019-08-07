package com.nacre.ofo.services;

import java.sql.SQLException;
import java.util.List;

import com.nacre.ofo.dao.AddressDAOI;
import com.nacre.ofo.dao.AddressDAOImpl;
import com.nacre.ofo.dao.StatusDAOImpl;
import com.nacre.ofo.dto.CityDto;
import com.nacre.ofo.dto.CountryDto;
import com.nacre.ofo.dto.OrderDto;
import com.nacre.ofo.dto.StateDto;

public class StatusServiceImpl implements StatusServiceI {

	@Override
	public List<OrderDto> statusService() throws SQLException {		
		return new StatusDAOImpl().statusDAO();
	}
}
