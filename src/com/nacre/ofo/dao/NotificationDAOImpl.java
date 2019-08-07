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

public class NotificationDAOImpl implements NotificationDAOI {
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	@Override
	public int getOrdersCount() throws SQLException {
		con=ConnectionUtility.getConnection();
		ps=con.prepareStatement(SQLQueryConstant.COUNT_ORDERS_QUERY);		
		rs=ps.executeQuery();
		if(rs.next()) {
			return rs.getInt(1);
		}		
		return 0;
	}
}
