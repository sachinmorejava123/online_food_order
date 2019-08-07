package com.nacre.ofo.services;

import java.sql.SQLException;

import com.nacre.ofo.dao.RegisterDao;
import com.nacre.ofo.dao.RegisterDaoImpl;
import com.nacre.ofo.dto.RegisterDto;

public class RegisterServiceImpl implements RegisterServiceI{

	@Override
	public int registerService(RegisterDto dto) throws SQLException {
		RegisterDao registerDao = new RegisterDaoImpl();		
		int r=registerDao.register(dto);		
		return r;
	}

}
