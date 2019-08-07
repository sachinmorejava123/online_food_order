package com.nacre.ofo.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.nacre.ofo.dto.ItemsDto;
import com.nacre.ofo.utility.ConnectionUtility;
import com.nacre.ofo.utility.SQLQueryConstant;

public class AddItemsDAOImpl implements AddItemsDAOI {

	@Override
	public int addItemsDAO(ItemsDto dto) throws SQLException, IOException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int count=0,itemId=0;
		
		con=ConnectionUtility.getConnection();		
		
		ps= con.prepareStatement(SQLQueryConstant.INSERT_ITEMS_QUERY,Statement.RETURN_GENERATED_KEYS);
		ps.setString(1,dto.getItemName());
		ps.setInt(2,dto.getItemPrice());
		ps.setInt(3,dto.getDeliveryCharge());
		ps.setFloat(4,dto.getDiscount());
		ps.setString(5,dto.getItemStatus());
		InputStream is=dto.getItemImage().getInputStream();		
		ps.setBlob(6,is);
		count=ps.executeUpdate();
		if(count>0) {
			rs=ps.getGeneratedKeys();
			rs.next();
			itemId=rs.getInt(1);
		}
		ps.close();
		con.close();
		return itemId;
	}
}
