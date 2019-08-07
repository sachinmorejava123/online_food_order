package com.nacre.ofo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.nacre.ofo.dto.AddressDto;
import com.nacre.ofo.dto.CityDto;
import com.nacre.ofo.dto.CountryDto;
import com.nacre.ofo.dto.ItemsDto;
import com.nacre.ofo.dto.OrderDto;
import com.nacre.ofo.dto.RegisterDto;
import com.nacre.ofo.dto.StateDto;
import com.nacre.ofo.utility.ConnectionUtility;
import com.nacre.ofo.utility.SQLQueryConstant;

public class OrderItemsDAOImpl implements OrderItemsDAOI {
	@Override
	public OrderDto orderItemsDAO(OrderDto odto) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null,ps1=null;
		ResultSet rs=null,rs1=null;
		OrderDto dto=null;
		
		con=ConnectionUtility.getConnection();
		
		ps1=con.prepareStatement(SQLQueryConstant.SELECT_BY_ITEMID_ITEMS_QUERY);
		ps1.setInt(1,odto.getItemId().getItemId());
		rs1=ps1.executeQuery();
		
		dto=new OrderDto();
		
		if(rs1.next()) {
			ItemsDto idto=new ItemsDto(); 
			idto.setItemId(rs1.getInt(1));
			idto.setItemName(rs1.getString(2));
			idto.setItemPrice(rs1.getInt(3));
			idto.setDeliveryCharge(rs1.getInt(4));
			idto.setDiscount(rs1.getInt(5));
			
			dto.setItemId(idto);
			
			ps=con.prepareStatement(SQLQueryConstant.SELECT_REGISTER_QUERY);
			ps.setString(1,odto.getRegId().getLoginId().getUsername());
			rs=ps.executeQuery();		
		
			if(rs.next()) {
				RegisterDto rdto=new RegisterDto();
				rdto.setRegisterId(rs.getInt(1));
				rdto.setCustFullName(rs.getString(2));
				rdto.setMobile(rs.getString(3));
				rdto.setEmail(rs.getString(4));
			
				AddressDto adto=new AddressDto();
				adto.setAddress(rs.getString(5));
				adto.setPincode(rs.getInt(6));
			
				CityDto cdto=new CityDto();
				cdto.setCityName(rs.getString(7));
				cdto.setCityId(rs.getInt(8));
			
				StateDto sdto=new StateDto();
				sdto.setStateName(rs.getString(9));
				sdto.setStateId(rs.getInt(10));
			
				CountryDto condto=new CountryDto();
				condto.setCountryName(rs.getString(11));
				condto.setCid(rs.getInt(12));
			
				sdto.setCountryId(condto);
			
				cdto.setStateId(sdto);
			
				adto.setCityId(cdto);
			
				rdto.setAddressId(adto);
				dto.setQuantity(odto.getQuantity());
				dto.setRegId(rdto);		
				System.out.println(dto);
			}	
		}
		ps.close();
		ps1.close();
		con.close();
		return dto;		
	}
}
