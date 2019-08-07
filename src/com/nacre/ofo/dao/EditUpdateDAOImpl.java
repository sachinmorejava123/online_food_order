package com.nacre.ofo.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpSession;

import com.nacre.ofo.dto.RegisterDto;
import com.nacre.ofo.utility.ConnectionUtility;
import com.nacre.ofo.utility.SQLQueryConstant;

public class EditUpdateDAOImpl implements EditUpdateDAOI {

	@Override
	public int editUpdateDAOI(RegisterDto dto) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null,ps1=null,ps2=null;
		ResultSet rs1=null,rs2=null;
		HttpSession hs=null;
		int count=0;
		
		con=ConnectionUtility.getConnection();		
		
		ps1= con.prepareStatement(SQLQueryConstant.SELECT_EDIT_ADDRESS_QUERY);		
		ps1.setInt(1, dto.getLoginId().getLoginId());
		rs1=ps1.executeQuery();
		
		if(rs1.next()) {
			int addressId=rs1.getInt("ADDRESS_ID");
			
			ps2= con.prepareStatement(SQLQueryConstant.UPDATE_EDIT_ADDRESS_QUERY);		
			ps2.setString(1,dto.getAddressId().getAddress());
			ps2.setInt(2,dto.getAddressId().getPincode());
			ps2.setInt(3, dto.getAddressId().getCityId().getCityId());
			ps2.setInt(4,addressId);			
			int updated1=ps2.executeUpdate();
			
			if(updated1>0) {			
				ps=con.prepareStatement(SQLQueryConstant.UPDATE_EDIT_CUSTOMER_QUERY);	
				ps.setString(1,dto.getCustFullName());
				ps.setString(2,dto.getMobile());
				ps.setString(3,dto.getEmail());
				ps.setInt(4,dto.getLoginId().getLoginId());
				count=ps.executeUpdate();
			}
		}	
		ps.close();
		ps2.close();
		ps1.close();
		con.close();
		return count;
	}
}	