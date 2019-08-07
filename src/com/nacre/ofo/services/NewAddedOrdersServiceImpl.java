package com.nacre.ofo.services;

import java.sql.SQLException;
import java.util.List;

import com.nacre.ofo.dao.NewAddedOrdersDAOImpl;
import com.nacre.ofo.dto.OrderDto;

public class NewAddedOrdersServiceImpl implements NewAddedOrdersServiceI {

	@Override
	public List<OrderDto> newAddedOrdersService() throws SQLException {
		return new NewAddedOrdersDAOImpl().newAddedOrdersDAO();
	}
}
