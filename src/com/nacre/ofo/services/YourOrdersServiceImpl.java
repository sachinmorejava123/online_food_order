package com.nacre.ofo.services;

import java.sql.SQLException;
import java.util.List;

import com.nacre.ofo.dao.YourOrdersDAOImpl;
import com.nacre.ofo.dto.OrderDto;

public class YourOrdersServiceImpl implements YourOrdersServiceI {

	@Override
	public List<OrderDto> yourOrdersService(String username) throws SQLException {
		return new YourOrdersDAOImpl().yourOrdersDAO(username);
	}

}
