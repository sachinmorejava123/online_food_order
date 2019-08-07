package com.nacre.ofo.services;

import java.sql.SQLException;

import com.nacre.ofo.dto.OrderDto;

public interface OrderItemsServiceI {
	public OrderDto orderItemsService(OrderDto dto) throws SQLException;
}
