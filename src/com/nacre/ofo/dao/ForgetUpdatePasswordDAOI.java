package com.nacre.ofo.dao;

import java.sql.SQLException;

import com.nacre.ofo.dto.LoginDto;

public interface ForgetUpdatePasswordDAOI {
	public int forgetUpdatePasswordDAO(LoginDto dto) throws SQLException;
}
