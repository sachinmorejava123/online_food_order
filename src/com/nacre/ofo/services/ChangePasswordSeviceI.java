package com.nacre.ofo.services;

import java.sql.SQLException;

import com.nacre.ofo.dto.ChangePasswordDto;

public interface ChangePasswordSeviceI {
	public int changePasswordService(ChangePasswordDto dto) throws SQLException;
}
