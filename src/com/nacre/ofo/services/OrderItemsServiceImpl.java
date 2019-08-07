package com.nacre.ofo.services;

import java.sql.SQLException;

import com.nacre.ofo.dao.OrderItemsDAOI;
import com.nacre.ofo.dao.OrderItemsDAOImpl;
import com.nacre.ofo.dto.ItemsDto;
import com.nacre.ofo.dto.OrderDto;

public class OrderItemsServiceImpl implements OrderItemsServiceI{

	@Override
	public OrderDto orderItemsService(OrderDto odto) throws SQLException {
		OrderItemsDAOI dao=new OrderItemsDAOImpl();
		OrderDto dto=new OrderDto();
		
		dto=dao.orderItemsDAO(odto);
		ItemsDto idto=dto.getItemId();
		
		int quantity=odto.getQuantity();
		int price=dto.getItemId().getItemPrice();
		float discount=dto.getItemId().getDiscount();
		float calcDiscount=(quantity*price*discount)/100;
		int deliveryCharge=dto.getItemId().getDeliveryCharge();
		float totalAmount=((quantity*price)+deliveryCharge)-calcDiscount;
		System.out.println("total.........."+totalAmount);
		idto.setTotalAmount(totalAmount);
		dto.setItemId(idto);
		System.out.println(dto);
		return dto;
	}

}
