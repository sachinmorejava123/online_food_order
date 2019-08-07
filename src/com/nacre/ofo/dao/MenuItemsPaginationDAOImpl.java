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

public class MenuItemsPaginationDAOImpl{
	public static final String SELECT_ITEMS_QUERY="SELECT ITEM_ID,ITEM_NAME,ITEM_PRICE,DELIVERY_CHARGE,DISCOUNT,ITEM_STATUS FROM ITEMS LIMIT ?, ?";
	public static final String COUNT_ITEMS_QUERY="SELECT COUNT(*) FROM ITEMS";
	
	Connection con=null;
	PreparedStatement ps=null,ps1=null;
	ResultSet resultSet=null,rs1=null;	
	
	public List<ItemsDto> menuItemsPaginationDAO(int startIndex, int recordsPerPage) throws SQLException {	
		List<ItemsDto> l=null;
			
		ItemsDto itemsDto=null;
		l=new ArrayList<>();
		
		ps=con.prepareStatement(SELECT_ITEMS_QUERY);
		ps.setInt(1,startIndex);
		ps.setInt(2,recordsPerPage);
		resultSet=ps.executeQuery();
			
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
	
			l.add(itemsDto);			
		}
		return l;
	}
	public int getTotalNumberOfRecords() throws SQLException {
		con=ConnectionUtility.getConnection();	
		ps1=con.prepareStatement(COUNT_ITEMS_QUERY);
		rs1=ps1.executeQuery();
		rs1.next();					
		return rs1.getInt(1);
	}
}
