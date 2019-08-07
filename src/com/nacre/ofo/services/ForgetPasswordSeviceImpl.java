package com.nacre.ofo.services;

import java.sql.SQLException;
import com.nacre.ofo.dao.ForgetPasswordDAOImpl;

public class ForgetPasswordSeviceImpl implements ForgetPasswordSeviceI{

	@Override
	public int forgetPasswordSevice(String username,String email) throws SQLException {
		return new ForgetPasswordDAOImpl().forgetPasswordDAO(username,email);
	}

}
