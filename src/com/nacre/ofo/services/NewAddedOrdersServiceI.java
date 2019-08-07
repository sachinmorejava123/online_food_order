package com.nacre.ofo.services;

import java.sql.SQLException;
import java.util.List;

import com.nacre.ofo.dto.OrderDto;

public interface NewAddedOrdersServiceI {
	public List<OrderDto> newAddedOrdersService() throws SQLException; 
}
