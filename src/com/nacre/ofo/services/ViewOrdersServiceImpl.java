package com.nacre.ofo.services;

import java.sql.SQLException;
import java.util.List;

import com.nacre.ofo.dao.ViewOrdersDAOImpl;
import com.nacre.ofo.dao.YourOrdersDAOImpl;
import com.nacre.ofo.dto.OrderDto;

public class ViewOrdersServiceImpl implements ViewOrdersServiceI {

	@Override
	public List<OrderDto> viewOrdersService(int startIndex, int recordsPerPage) throws SQLException {
		return new ViewOrdersDAOImpl().viewOrdersDAO(startIndex,recordsPerPage);
	}
	@Override
	public int getTotalNumberOfRecords() throws SQLException {
		return new ViewOrdersDAOImpl().getTotalNumberOfRecords();
	}
}
