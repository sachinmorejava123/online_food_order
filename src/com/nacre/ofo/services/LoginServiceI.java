package com.nacre.ofo.services;

import java.sql.SQLException;

import com.nacre.ofo.dto.LoginDto;

public interface LoginServiceI {
	public LoginDto loginService(LoginDto dto) throws SQLException;
}
