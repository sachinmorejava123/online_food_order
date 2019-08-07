package com.nacre.ofo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.nacre.ofo.dto.CountryDto;
import com.nacre.ofo.dto.OrderDto;
import com.nacre.ofo.utility.ConnectionUtility;
import com.nacre.ofo.utility.SQLQueryConstant;

public class StatusDAOImpl implements StatusDAOI {

	@Override
	public List<OrderDto> statusDAO() throws SQLException {
		Connection con=null;
		ResultSet rs=null;
		PreparedStatement ps=null;				
		List<OrderDto> l=null;
		
		con=ConnectionUtility.getConnection();
		ps=con.prepareStatement(SQLQueryConstant.SELECT_STATUS_QUERY);
		
		rs=ps.executeQuery();
		
		OrderDto dto=null;
		l=new ArrayList<OrderDto>();
		
		while(rs.next()) {
			dto= new OrderDto();			
			int statusid=rs.getInt(1);
			String statusName=rs.getString(2);
			
			dto.setOrderStatusId(statusid);
			dto.setOrderStatusName(statusName);;
			
			l.add(dto);			
		}	
		return l;
	}
}
