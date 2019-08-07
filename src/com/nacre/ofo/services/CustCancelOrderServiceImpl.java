package com.nacre.ofo.services;

import java.sql.SQLException;
import java.util.List;

import com.nacre.ofo.dao.CustCancelOrderDAOImpl;
import com.nacre.ofo.dao.YourOrdersDAOImpl;
import com.nacre.ofo.dto.OrderDto;

public class CustCancelOrderServiceImpl implements CustCancelOrderServiceI {

	@Override
	public int custCancelOrderService(String username,int orderId) throws SQLException {
		return new CustCancelOrderDAOImpl().yourOrdersDAO(username, orderId);
	}

}
