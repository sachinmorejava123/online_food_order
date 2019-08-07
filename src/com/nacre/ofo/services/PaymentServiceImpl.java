package com.nacre.ofo.services;

import java.sql.SQLException;

import com.nacre.ofo.dao.OrderItemsDAOI;
import com.nacre.ofo.dao.OrderItemsDAOImpl;
import com.nacre.ofo.dao.PaymentDAOImpl;
import com.nacre.ofo.dto.ItemsDto;
import com.nacre.ofo.dto.OrderDto;

public class PaymentServiceImpl implements PaymentServiceI{

	@Override
	public int paymentService(OrderDto dto) throws SQLException {
		return new PaymentDAOImpl().paymentDAO(dto);
	}

}
