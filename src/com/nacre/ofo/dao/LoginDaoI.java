package com.nacre.ofo.dao;

import java.sql.SQLException;

import com.nacre.ofo.dto.LoginDto;

public interface LoginDaoI {
	public LoginDto loginDAO(LoginDto dto) throws SQLException;
}
