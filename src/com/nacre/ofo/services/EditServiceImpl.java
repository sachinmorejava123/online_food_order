package com.nacre.ofo.services;

import java.sql.SQLException;

import com.nacre.ofo.dao.EditDAOImpl;
import com.nacre.ofo.dto.RegisterDto;

public class EditServiceImpl implements EditServiceI {

	@Override
	public RegisterDto editService(String user) throws SQLException {
		return new EditDAOImpl().getEditDAO(user);
	}

}
