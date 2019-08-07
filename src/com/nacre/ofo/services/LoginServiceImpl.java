package com.nacre.ofo.services;

import java.sql.SQLException;

import com.nacre.ofo.dao.LoginDaoI;
import com.nacre.ofo.dao.LoginDaoImpl;
import com.nacre.ofo.dto.LoginDto;

public class LoginServiceImpl implements LoginServiceI{
	

	@Override
	public LoginDto loginService(LoginDto dto) throws SQLException {
		LoginDaoI loginDaoI=new LoginDaoImpl();
		LoginDto ldto=loginDaoI.loginDAO(dto);
		return ldto;
	}

}
