package com.nacre.ofo.services;

import java.sql.SQLException;

public interface ForgetPasswordSeviceI {
	public int forgetPasswordSevice(String username,String email) throws SQLException;
}
