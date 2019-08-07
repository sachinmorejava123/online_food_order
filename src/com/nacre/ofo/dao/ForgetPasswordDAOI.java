package com.nacre.ofo.dao;

import java.sql.SQLException;

import com.nacre.ofo.dto.ChangePasswordDto;

public interface ForgetPasswordDAOI {
	public int forgetPasswordDAO(String username,String email) throws SQLException;
}
