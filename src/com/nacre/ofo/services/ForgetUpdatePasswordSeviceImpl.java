package com.nacre.ofo.services;

import java.sql.SQLException;
import com.nacre.ofo.dao.ForgetUpdatePasswordDAOImpl;
import com.nacre.ofo.dto.LoginDto;

public class ForgetUpdatePasswordSeviceImpl implements ForgetUpdatePasswordSeviceI{

	@Override
	public int forgetUpdatePasswordSevice(LoginDto dto) throws SQLException {
		return new ForgetUpdatePasswordDAOImpl().forgetUpdatePasswordDAO(dto);
	}

}
