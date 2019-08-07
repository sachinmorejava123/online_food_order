package com.nacre.ofo.dao;

import java.sql.SQLException;

import com.nacre.ofo.dto.OrderDto;

public interface PaymentDAOI {
	public int paymentDAO(OrderDto dto) throws SQLException;
}
