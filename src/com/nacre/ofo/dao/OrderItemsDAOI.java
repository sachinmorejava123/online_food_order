package com.nacre.ofo.dao;

import java.sql.SQLException;

import com.nacre.ofo.dto.OrderDto;

public interface OrderItemsDAOI {
	public OrderDto orderItemsDAO(OrderDto odto) throws SQLException;
}
