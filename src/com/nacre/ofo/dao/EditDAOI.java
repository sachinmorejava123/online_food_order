package com.nacre.ofo.dao;

import java.sql.SQLException;

import com.nacre.ofo.dto.RegisterDto;

public interface EditDAOI {
	public RegisterDto getEditDAO(String user) throws SQLException;
}
