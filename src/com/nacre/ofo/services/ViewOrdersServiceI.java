package com.nacre.ofo.services;

import java.sql.SQLException;
import java.util.List;

import com.nacre.ofo.dto.OrderDto;

public interface ViewOrdersServiceI {
	public List<OrderDto> viewOrdersService(int startIndex, int recordsPerPage) throws SQLException;
	public int getTotalNumberOfRecords() throws SQLException;
}
