package com.nacre.ofo.dao;


import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nacre.ofo.dto.ItemsDto;
import com.nacre.ofo.utility.ConnectionUtility;
import com.nacre.ofo.utility.SQLQueryConstant;

public class MenuItemsDAOImpl implements MenuItemsDAOI{
	Connection con=null;
	PreparedStatement ps=null,ps1=null;
	ResultSet resultSet=null,rs1=null;
	
	@Override
	public List<ItemsDto> menuItemsDAO(int startIndex,int recordsPerPage) throws SQLException {		
		List<ItemsDto> l=null;	
		ItemsDto itemsDto=null;
		
		con=ConnectionUtility.getConnection();
		
		ps=con.prepareStatement(SQLQueryConstant.SELECT_ITEMS_QUERY);
		ps.setInt(1,startIndex);
		ps.setInt(2,recordsPerPage);
		resultSet=ps.executeQuery();
		
		l=new ArrayList<>();
			
		while(resultSet.next()) {
			itemsDto= new ItemsDto();			
			int items_id=resultSet.getInt(1);
			String items_name=resultSet.getString(2);
			int price=resultSet.getInt(3);
			int deliveryCharge=resultSet.getInt(4);
			float discount=resultSet.getFloat(5);
			
			itemsDto.setItemId(items_id);
			itemsDto.setItemName(items_name);
			itemsDto.setItemPrice(price);
			itemsDto.setDeliveryCharge(deliveryCharge);
			itemsDto.setDiscount(discount);
			itemsDto.setItemStatus(resultSet.getString("item_status"));
			
			/*Blob image = resultSet.getBlob("item_image");
			itemsDto.setItemsImage(image);*/
				
			l.add(itemsDto);			
		}
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
