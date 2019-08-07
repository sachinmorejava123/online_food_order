package com.nacre.ofo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.nacre.ofo.dto.ChangePasswordDto;
import com.nacre.ofo.utility.ConnectionUtility;
import com.nacre.ofo.utility.SQLQueryConstant;

public class ChangePasswordDAOImpl implements ChangePasswordDAOI {

	@Override
	public int changePasswordDAO(ChangePasswordDto dto) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null,ps1=null;
		con=ConnectionUtility.getConnection();
		ps=con.prepareStatement(SQLQueryConstant.SELECT_LOGIN_QUERY);
		ps.setString(1,dto.getUsername());
		ps.setString(2,dto.getOldPassword());
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			ps1=con.prepareStatement(SQLQueryConstant.UPDATE_LOGIN_QUERY);
			ps1.setString(1,dto.getNewPassword());
			ps1.setString(2,dto.getUsername());
			int i=ps1.executeUpdate();
			if(i>0)
				return 1;
			else
				return 0;
		}
		else {
			return 0;	
		}			
	}

}
