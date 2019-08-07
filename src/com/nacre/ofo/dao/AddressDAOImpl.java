package com.nacre.ofo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nacre.ofo.dto.AddressDto;
import com.nacre.ofo.dto.CityDto;
import com.nacre.ofo.dto.CountryDto;
import com.nacre.ofo.dto.StateDto;
import com.nacre.ofo.utility.ConnectionUtility;
import com.nacre.ofo.utility.SQLQueryConstant;

public class AddressDAOImpl implements AddressDAOI {
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet resultSet=null;
	@Override
	public List<CountryDto> getCountry() throws SQLException {		
		List<CountryDto> l=null;
		con=ConnectionUtility.getConnection();
		ps=con.prepareStatement(SQLQueryConstant.GET_COUNTRY_QUERY);
		
		resultSet=ps.executeQuery();
		
		CountryDto countryDto=null;
		l=new ArrayList<>();
		
		while(resultSet.next()) {
			countryDto= new CountryDto();			
			int id=resultSet.getInt(1);
			String country=resultSet.getString(2);
			
			countryDto.setCountryName(country);
			countryDto.setCid(id);
			
			l.add(countryDto);			
		}	
		return l;
	}

	@Override
	public List<StateDto> getStateDAO(int cid)  throws SQLException{
		List<StateDto> l=null;
		StateDto stateDto=null;
		
		con=ConnectionUtility.getConnection();
		ps=con.prepareStatement(SQLQueryConstant.GET_STATE_QUERY);
		ps.setInt(1,cid);
		resultSet=ps.executeQuery();		
		l=new ArrayList<>();
		while(resultSet.next()) {
			stateDto= new StateDto();			
			int stateId=resultSet.getInt(1);
			String stateName=resultSet.getString(2);			
			stateDto.setStateName(stateName);
			stateDto.setStateId(stateId);			
			l.add(stateDto);			
		}	
		return l;
	}

	@Override
	public List<CityDto> getCityDAO(int cityid) throws SQLException {
		List<CityDto> l=null;
		CityDto cityDto=null;
		
		con=ConnectionUtility.getConnection();
		ps=con.prepareStatement(SQLQueryConstant.GET_CITY_QUERY);
		ps.setInt(1,cityid);
		resultSet=ps.executeQuery();		
		l=new ArrayList<>();
		while(resultSet.next()) {
			cityDto= new CityDto();			
			int stateId=resultSet.getInt(1);
			String stateName=resultSet.getString(2);			
			cityDto.setCityName(stateName);
			cityDto.setCityId(stateId);			
			l.add(cityDto);			
		}	
		return l;
	}

}
