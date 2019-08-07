package com.nacre.ofo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.nacre.ofo.dto.ItemsDto;
import com.nacre.ofo.dto.RegisterDto;
import com.nacre.ofo.utility.ConnectionUtility;
import com.nacre.ofo.utility.SQLQueryConstant;

public class EditItemsDAOImpl implements EditItemsDAOI {

	@Override
	public int editItemsDAO(ItemsDto dto) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		con=ConnectionUtility.getConnection();
		ps=con.prepareStatement(SQLQueryConstant.EDIT_ITEMS_QUERY);		
		ps.setString(1,dto.getItemName());
		ps.setInt(2,dto.getItemPrice());
		ps.setInt(3,dto.getDeliveryCharge());
		ps.setFloat(4,dto.getDiscount());		
		ps.setString(5,dto.getItemStatus());
		ps.setInt(6,dto.getItemId());
		
		int count=ps.executeUpdate();
		if(count>0) {
			ps.close();
			con.close();
			return 1;
		}
		else {
			ps.close();
			con.close();
			return 0;
		}
	}
}
