package com.nacre.ofo.dao;

import java.sql.Connection;
import java.util.Calendar;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpSession;

import com.nacre.ofo.dto.OrderDto;
import com.nacre.ofo.dto.RegisterDto;
import com.nacre.ofo.utility.ConnectionUtility;
import com.nacre.ofo.utility.SQLQueryConstant;

public class PaymentDAOImpl implements PaymentDAOI {

	@Override
	public int paymentDAO(OrderDto dto) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null,ps1=null,ps2=null,ps3=null,ps4=null;
		ResultSet rs1=null,rs2=null;
		int count=0,count1=0,count2=0;
		java.sql.Date date1=null;
		
		con=ConnectionUtility.getConnection();		
		
		ps1= con.prepareStatement(SQLQueryConstant.SELECT_EDIT_ADDRESS_QUERY);		
		ps1.setInt(1, dto.getRegId().getLoginId().getLoginId());
		rs1=ps1.executeQuery();
		
		if(rs1.next()) {
			int addressId=rs1.getInt("ADDRESS_ID");
			
			ps2= con.prepareStatement(SQLQueryConstant.UPDATE_EDIT_ADDRESS_QUERY);		
			ps2.setString(1,dto.getRegId().getAddressId().getAddress());
			ps2.setInt(2,dto.getRegId().getAddressId().getPincode());
			ps2.setInt(3, dto.getRegId().getAddressId().getCityId().getCityId());
			ps2.setInt(4,addressId);			
			int updated1=ps2.executeUpdate();
			
			if(updated1>0) {			
				ps=con.prepareStatement(SQLQueryConstant.UPDATE_EDIT_CUSTOMER_QUERY);	
				ps.setString(1,dto.getRegId().getCustFullName());
				ps.setString(2,dto.getRegId().getMobile());
				ps.setString(3,dto.getRegId().getEmail());
				ps.setInt(4,dto.getRegId().getLoginId().getLoginId());
				count=ps.executeUpdate();			
				
				if(count>0) {					
					ps3=con.prepareStatement(SQLQueryConstant.INSERT_ORDERS_QUERY);	
					ps3.setInt(1,dto.getRegId().getRegisterId());
					ps3.setInt(2,dto.getItemId().getItemId());
					ps3.setInt(3,dto.getQuantity());
					ps3.setFloat(4,dto.getItemId().getTotalAmount());
					
					Date date=new Date();
					long d=date.getTime();
					date1=new java.sql.Date(d);
					
					System.out.println(date1+"    "+date);
					ps3.setDate(5,date1);	
					ps3.setInt(6,1);	
					
					count1=ps3.executeUpdate();
					
					if(count1>0) {
						ps4=con.prepareStatement(SQLQueryConstant.COUNT_ORDERS_QUERY);
						rs2=ps4.executeQuery();
						
						if(rs2.next()) {
							count2=rs2.getInt(1);
						
							ps4.close();
							ps3.close();
							ps.close();
							ps2.close();
							ps1.close();
							con.close();
							return count2;
						}
					}else {
						ps3.close();
						ps.close();
						ps2.close();
						ps1.close();
						con.close();
						return count;
					}
				}
			}
		}
		return count1;
	}
}	