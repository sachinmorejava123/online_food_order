package com.nacre.ofo.services;

import java.sql.SQLException;

import com.nacre.ofo.dao.EditUpdateDAOImpl;
import com.nacre.ofo.dto.RegisterDto;

public class EditUpdateServiceImpl implements EditUpdateServiceI {

	@Override
	public int editUpdateService(RegisterDto dto) throws SQLException {
		return new EditUpdateDAOImpl().editUpdateDAOI(dto);
	}

}
