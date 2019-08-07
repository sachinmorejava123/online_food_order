package com.nacre.ofo.services;


import java.sql.SQLException;

import com.nacre.ofo.dto.OrderDto;
import com.nacre.ofo.dto.RegisterDto;

public interface EditServiceI {
	public RegisterDto editService(String username) throws SQLException;
}
