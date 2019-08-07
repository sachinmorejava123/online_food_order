package com.nacre.ofo.dao;

import java.sql.SQLException;

import com.nacre.ofo.dto.RegisterDto;

public interface EditUpdateDAOI {
	public int editUpdateDAOI(RegisterDto dto) throws SQLException;
}
