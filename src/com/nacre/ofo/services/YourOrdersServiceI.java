package com.nacre.ofo.services;

import java.sql.SQLException;
import java.util.List;

import com.nacre.ofo.dto.OrderDto;

public interface YourOrdersServiceI {
	public List<OrderDto> yourOrdersService(String username) throws SQLException; 
}
