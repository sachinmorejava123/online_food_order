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
import com.nacre.ofo.dto.ItemsDto;
import com.nacre.ofo.dto.OrderDto;
import com.nacre.ofo.dto.RegisterDto;
import com.nacre.ofo.utility.ConnectionUtility;
import com.nacre.ofo.utility.SQLQueryConstant;

public class ViewOrdersDAOImpl implements ViewOrdersDAOI {
	Connection con=null;
	PreparedStatement ps=null,ps1=null;
	ResultSet rs=null,rs1=null;
	@Override
	public  List<OrderDto> viewOrdersDAO(int startIndex, int recordsPerPage) throws SQLException {		
		List<OrderDto> l=null;
		con=ConnectionUtility.getConnection();
		ps=con.prepareStatement(SQLQueryConstant.SELECT_VIEW_ORDERS_ITEMS_QUERY);
		ps.setInt(1,startIndex);
		ps.setInt(2,recordsPerPage);
		rs=ps.executeQuery();
		
		OrderDto dto=null;
		ItemsDto idto=null;
		RegisterDto rdto=null;
		AddressDto adto=null;
		CityDto cdto=null;
		
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
			idto.setItemId(rs.getInt("item_id"));
			idto.setTotalAmount(rs.getFloat("total_amount"));
			idto.setItemName(rs.getString("item_name"));
			idto.setItemPrice(rs.getInt("item_price"));			
			dto.setItemId(idto);
			
			rdto=new RegisterDto();
			adto=new AddressDto();
			adto.setAddress(rs.getString("address_name"));			
			cdto=new CityDto();
			cdto.setCityName(rs.getString("city_name"));
			adto.setCityId(cdto);
			rdto.setAddressId(adto);
			dto.setRegId(rdto);
			
			l.add(dto);				
		}
		System.out.println("view orders"+l);
		return l;	
	}
	@Override
	public int getTotalNumberOfRecords() throws SQLException {
		con=ConnectionUtility.getConnection();	
		ps1=con.prepareStatement(SQLQueryConstant.COUNT_ITEMS_QUERY);
		rs1=ps1.executeQuery();
		rs1.next();					
		return rs1.getInt(1);
	}
}
