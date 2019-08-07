package com.nacre.ofo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.nacre.ofo.dto.AddressDto;
import com.nacre.ofo.dto.CityDto;
import com.nacre.ofo.dto.CountryDto;
import com.nacre.ofo.dto.ItemsDto;
import com.nacre.ofo.dto.OrderDto;
import com.nacre.ofo.dto.RegisterDto;
import com.nacre.ofo.dto.StateDto;
import com.nacre.ofo.utility.ConnectionUtility;
import com.nacre.ofo.utility.SQLQueryConstant;

public class ChangeStatusOrdersDAOImpl implements ChangeStatusOrdersDAOI {
	Connection con=null;
	PreparedStatement ps=null,ps1=null,ps2=null;
	ResultSet rs1=null,rs2=null;
	OrderDto dto=null;
	RegisterDto rdto=null;
	@Override
	public OrderDto changeStatusOrdersDAO(int status,int orderId) throws SQLException{	
		dto=new OrderDto();
		
		con=ConnectionUtility.getConnection();
		ps=con.prepareStatement(SQLQueryConstant.CHANGE_STATUS_ORDERS_ITEMS_QUERY);
		ps.setInt(1,status);
		ps.setInt(2,orderId);		
		int count=ps.executeUpdate();
		if(count>0) {
			ps1=con.prepareStatement(SQLQueryConstant.SELECT_EMAIL_ORDERS_ITEMS_QUERY);
			ps1.setInt(1,orderId);
			rs1=ps1.executeQuery();
			if(rs1.next()) {
				rdto=new RegisterDto();
				rdto.setEmail(rs1.getString("EMAIL"));
				dto.setRegId(rdto);
				
				ps2=con.prepareStatement(SQLQueryConstant.COUNT_ORDERS_QUERY);			
				rs2=ps2.executeQuery();
				if(rs2.next()) {
					dto.setCountNewOrder(rs2.getInt(1));
					return dto;
				}
			}
		}			
		return null;	
	}
}
