package com.nacre.ofo.dao;

import java.sql.SQLException;
import java.util.List;

import com.nacre.ofo.dto.OrderDto;

public interface ViewOrdersDAOI {	
	public List<OrderDto> viewOrdersDAO(int startIndex, int recordsPerPage) throws SQLException;
	public int getTotalNumberOfRecords() throws SQLException;
}
