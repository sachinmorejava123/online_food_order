package com.nacre.ofo.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.nacre.ofo.dto.RegisterDto;
import com.nacre.ofo.utility.ConnectionUtility;
import com.nacre.ofo.utility.SQLQueryConstant;

public class RegisterDaoImpl implements RegisterDao {
	@Override
	public int register(RegisterDto dto) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null,ps1=null,ps2=null;
		ResultSet rs=null,rs1=null;
		int count=0,key=0,lid=0;
		
		con=ConnectionUtility.getConnection();		
		
		ps2= con.prepareStatement(SQLQueryConstant.INSERT_LOGIN_QUERY, Statement.RETURN_GENERATED_KEYS);
		ps2.setString(1,dto.getLoginId().getUsername());
		ps2.setString(2,dto.getLoginId().getPassword());
		ps2.setInt(3,2);
		int updated1=ps2.executeUpdate();
		
		if(updated1>0) {
			rs1=ps2.getGeneratedKeys();
			rs1.next();
			lid = rs1.getInt(1);
			
			ps1= con.prepareStatement(SQLQueryConstant.SET_ADDRESS_QUERY, Statement.RETURN_GENERATED_KEYS);		
			ps1.setString(1,dto.getAddressId().getAddress());
			ps1.setInt(2,dto.getAddressId().getPincode());
			ps1.setInt(3, dto.getAddressId().getCityId().getCityId());
			int updated=ps1.executeUpdate();
			
			if(updated>0) {
				rs=ps1.getGeneratedKeys();
				rs.next();
				key = rs.getInt(1);
				
				ps=con.prepareStatement(SQLQueryConstant.INSERT_CUSTOMER_QUERY);	
				ps.setString(1,dto.getCustFullName());		
				ps.setString(2,dto.getGender());
				ps.setDate(3,(Date) dto.getDob());
				ps.setString(4,dto.getMobile());
				ps.setString(5,dto.getEmail());	
				ps.setInt(6,lid);
				ps.setInt(7,key);
				count=ps.executeUpdate();
			}
		}		
		ps.close();
		con.close();
		return count;
	}
}
