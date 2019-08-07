package com.nacre.ofo.services;

import java.sql.SQLException;
import com.nacre.ofo.dto.OrderDto;

public interface PaymentServiceI {
	public int paymentService(OrderDto dto) throws SQLException;
}
