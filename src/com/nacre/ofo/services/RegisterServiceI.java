package com.nacre.ofo.services;

import java.sql.SQLException;

import com.nacre.ofo.dto.RegisterDto;

public interface RegisterServiceI {
	public int registerService(RegisterDto dto) throws SQLException;

}
