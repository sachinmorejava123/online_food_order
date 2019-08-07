package com.nacre.ofo.services;

import java.sql.SQLException;

import com.nacre.ofo.dao.ChangePasswordDAOImpl;
import com.nacre.ofo.dto.ChangePasswordDto;

public class ChangePasswordServiceImpl implements ChangePasswordSeviceI{

	@Override
	public int changePasswordService(ChangePasswordDto dto) throws SQLException {
		return new ChangePasswordDAOImpl().changePasswordDAO(dto);
	}

}
