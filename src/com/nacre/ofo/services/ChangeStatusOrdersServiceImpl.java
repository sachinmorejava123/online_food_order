package com.nacre.ofo.services;

import java.sql.SQLException;

import com.nacre.ofo.dao.ChangeStatusOrdersDAOImpl;
import com.nacre.ofo.dto.OrderDto;

public class ChangeStatusOrdersServiceImpl implements ChangeStatusOrdersServiceI {

	@Override
	public OrderDto changeStatusOrdersService(int status,int orderId) throws SQLException {
		return new ChangeStatusOrdersDAOImpl().changeStatusOrdersDAO(status, orderId);
	}

}
