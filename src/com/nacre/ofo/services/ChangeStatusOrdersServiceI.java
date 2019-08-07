package com.nacre.ofo.services;

import java.sql.SQLException;

import com.nacre.ofo.dto.OrderDto;

public interface ChangeStatusOrdersServiceI {
	public OrderDto changeStatusOrdersService(int status,int orderId) throws SQLException;
}
