package com.nacre.ofo.dao;

import java.sql.SQLException;
import java.util.List;

import com.nacre.ofo.dto.OrderDto;

public interface StatusDAOI {
	public List<OrderDto> statusDAO() throws SQLException;
}
