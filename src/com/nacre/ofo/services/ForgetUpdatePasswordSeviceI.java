package com.nacre.ofo.services;

import java.sql.SQLException;

import com.nacre.ofo.dto.LoginDto;

public interface ForgetUpdatePasswordSeviceI {
	public int forgetUpdatePasswordSevice(LoginDto dto) throws SQLException;
}
