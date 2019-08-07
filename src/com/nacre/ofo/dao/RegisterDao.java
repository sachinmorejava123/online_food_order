package com.nacre.ofo.dao;

import java.sql.SQLException;

import com.nacre.ofo.dto.RegisterDto;

public interface RegisterDao {
	public int register(RegisterDto dto) throws SQLException;
}
