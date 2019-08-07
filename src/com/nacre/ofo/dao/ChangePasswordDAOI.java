package com.nacre.ofo.dao;

import java.sql.SQLException;

import com.nacre.ofo.dto.ChangePasswordDto;

public interface ChangePasswordDAOI {
	public int changePasswordDAO(ChangePasswordDto dto) throws SQLException;
}
