package com.nacre.ofo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.nacre.ofo.dto.ChangePasswordDto;
import com.nacre.ofo.utility.ConnectionUtility;
import com.nacre.ofo.utility.SQLQueryConstant;

public class ForgetPasswordDAOImpl implements ForgetPasswordDAOI {

	@Override
	public int forgetPasswordDAO(String username,String email) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null,ps1=null;
		
		con=ConnectionUtility.getConnection();
		
		ps=con.prepareStatement(SQLQueryConstant.SELECT_FORGET_LOGIN_QUERY);
		ps.setString(1,email);
		ps.setString(2,username);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			return rs.getInt(1);
		}
		else {
			return 0;	
		}			
	}

}
