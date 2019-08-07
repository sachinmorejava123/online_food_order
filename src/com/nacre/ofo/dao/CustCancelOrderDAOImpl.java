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

public class CustCancelOrderDAOImpl implements CustCancelOrderDAOI {
	Connection con=null;
	PreparedStatement ps=null;
	
	@Override
	public int yourOrdersDAO(String username,int orderId) throws SQLException{	
		
		con=ConnectionUtility.getConnection();
		ps=con.prepareStatement(SQLQueryConstant.CUST_CANCEL_ORDERS_ITEMS_QUERY);
		ps.setInt(1,orderId);
		int count=ps.executeUpdate();
		if(count>0)
			return 1;
		return 0;	
	}
}
