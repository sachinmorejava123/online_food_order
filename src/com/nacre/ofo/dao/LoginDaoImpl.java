package com.nacre.ofo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.nacre.ofo.dto.LoginDto;
import com.nacre.ofo.dto.RegisterDto;
import com.nacre.ofo.dto.RoleDto;
import com.nacre.ofo.utility.ConnectionUtility;
import com.nacre.ofo.utility.SQLQueryConstant;

public class LoginDaoImpl implements LoginDaoI {

	@Override
	public LoginDto loginDAO(LoginDto dto) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null,ps1=null;
		ResultSet rs=null,rs1=null;
		
		con=ConnectionUtility.getConnection();
		
		ps=con.prepareStatement(SQLQueryConstant.SELECT_LOGIN_QUERY);
		ps.setString(1,dto.getUsername());
		ps.setString(2,dto.getPassword());
		rs=ps.executeQuery();
		if(rs.next()) {
			int loginId=rs.getInt("LOGIN_ID");			
			
			RoleDto rdto=new RoleDto();
			int roleId=rs.getInt("ROLE_ID");
			if(roleId==1 || roleId==2) {
				rdto.setRoleId(roleId);
				dto.setLoginId(loginId);
			
				dto.setRoleId(rdto);
				
				dto.setReg_Id(rs.getInt("REG_ID"));
				
			}		
			
			
			ps1=con.prepareStatement(SQLQueryConstant.COUNT_ORDERS_QUERY);			
			rs1=ps1.executeQuery();
			if(rs1.next()) {
				dto.setCountNewOrderLogin(rs1.getInt(1));
				return dto;
			}
		}
		else {
			return null;	
		}
		ps.close();
		con.close();
		
		return dto;
	}

}
