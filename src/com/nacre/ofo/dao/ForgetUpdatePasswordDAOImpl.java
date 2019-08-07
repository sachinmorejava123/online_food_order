package com.nacre.ofo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.nacre.ofo.dto.LoginDto;
import com.nacre.ofo.utility.ConnectionUtility;
import com.nacre.ofo.utility.SQLQueryConstant;

public class ForgetUpdatePasswordDAOImpl implements ForgetUpdatePasswordDAOI {

	@Override
	public int forgetUpdatePasswordDAO(LoginDto dto) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		
		con=ConnectionUtility.getConnection();
		
		ps=con.prepareStatement(SQLQueryConstant.UPDATE_FORGET_LOGIN_QUERY);
		ps.setString(1,dto.getPassword());
		ps.setString(2,dto.getUsername());
		int count=ps.executeUpdate();
		if(count>0) {
			return 1;
		}
		else {
			return 0;	
		}			
	}

}
