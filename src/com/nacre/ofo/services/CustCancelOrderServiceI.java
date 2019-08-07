package com.nacre.ofo.services;

import java.sql.SQLException;

public interface CustCancelOrderServiceI {
	public int custCancelOrderService(String username,int orderId) throws SQLException;
}
