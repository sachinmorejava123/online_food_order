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
import com.nacre.ofo.dto.StateDto;
import com.nacre.ofo.utility.ConnectionUtility;
import com.nacre.ofo.utility.SQLQueryConstant;

public class YourOrdersDAOImpl implements YourOrdersDAOI {
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	@Override
	public  List<OrderDto> yourOrdersDAO(String username) throws SQLException {		
		List<OrderDto> l=null;
		con=ConnectionUtility.getConnection();
		ps=con.prepareStatement(SQLQueryConstant.SELECT_ORDERS_ITEMS_QUERY);
		ps.setString(1,username);
		rs=ps.executeQuery();
		
		OrderDto dto=null;
		ItemsDto idto=null;
		l=new ArrayList<OrderDto>();
		
		while(rs.next()) {
			dto= new OrderDto();	
			dto.setOrderId(rs.getInt("order_id"));
			dto.setQuantity(rs.getInt("quantity"));
			dto.setOrderStatusId(rs.getInt("status"));
			dto.setOrderStatusName(rs.getString("status_name"));
			
			java.sql.Date d=rs.getDate("order_date");
			Date d1=(Date)d;
			SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
			String date=sdf.format(d1);
			dto.setOrderDate(date);
			
			idto=new ItemsDto();
			idto.setTotalAmount(rs.getFloat("total_amount"));
			idto.setItemName(rs.getString("item_name"));
			idto.setItemPrice(rs.getInt("item_price"));
			idto.setDeliveryCharge(rs.getInt("delivery_charge"));
			idto.setDiscount(rs.getFloat("discount"));
			
			dto.setItemId(idto);
			
			l.add(dto);			
		}
		return l;	
	}
}
