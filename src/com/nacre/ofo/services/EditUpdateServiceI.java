package com.nacre.ofo.services;

import java.sql.SQLException;

import com.nacre.ofo.dto.RegisterDto;

public interface EditUpdateServiceI {
	public int editUpdateService(RegisterDto dto) throws SQLException;
}
