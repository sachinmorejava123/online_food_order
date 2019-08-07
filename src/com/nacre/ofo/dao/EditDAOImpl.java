package com.nacre.ofo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.nacre.ofo.dto.AddressDto;
import com.nacre.ofo.dto.CityDto;
import com.nacre.ofo.dto.CountryDto;
import com.nacre.ofo.dto.RegisterDto;
import com.nacre.ofo.dto.StateDto;
import com.nacre.ofo.utility.ConnectionUtility;
import com.nacre.ofo.utility.SQLQueryConstant;


public class EditDAOImpl implements EditDAOI {
	@Override
	public RegisterDto getEditDAO(String user) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		RegisterDto dto=null;
		
		con=ConnectionUtility.getConnection();
		ps=con.prepareStatement(SQLQueryConstant.SELECT_REGISTER_QUERY);
		ps.setString(1,user);
		rs=ps.executeQuery();
		dto=new RegisterDto();
		if(rs.next()) {
			dto.setRegisterId(rs.getInt(1));
			dto.setCustFullName(rs.getString(2));
			dto.setMobile(rs.getString(3));
			dto.setEmail(rs.getString(4));
			
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
			
			dto.setAddressId(adto);	
			
			ps.close();
			con.close();
			return dto;
		}else 
			return null;
	}
}
