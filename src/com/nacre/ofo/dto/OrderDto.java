package com.nacre.ofo.dto;

import java.io.Serializable;
import java.util.Date;

public class OrderDto implements Serializable {
	private int orderId;
	private int quantity;
	private String orderDate;
	private String orderStatusName;
	private int orderStatusId;
	private RegisterDto regId;
	private ItemsDto itemId;
	private int countNewOrder;
	
	public int getCountNewOrder() {
		return countNewOrder;
	}
	public void setCountNewOrder(int countNewOrder) {
		this.countNewOrder = countNewOrder;
	}
	public int getOrderStatusId() {
		return orderStatusId;
	}
	public void setOrderStatusId(int orderStatusId) {
		this.orderStatusId = orderStatusId;
	}
	public String getOrderStatusName() {
		return orderStatusName;
	}
	public void setOrderStatusName(String orderStatusName) {
		this.orderStatusName = orderStatusName;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public RegisterDto getRegId() {
		return regId;
	}
	public void setRegId(RegisterDto regId) {
		this.regId = regId;
	}
	public ItemsDto getItemId() {
		return itemId;
	}
	public void setItemId(ItemsDto itemId) {
		this.itemId = itemId;
	}
	
	@Override
	public String toString() {
		return "OrderDto [orderId=" + orderId + ", quantity=" + quantity + ", orderDate=" + orderDate
				+ ", orderStatusName=" + orderStatusName + ", orderStatusId=" + orderStatusId + ", regId=" + regId
				+ ", itemId=" + itemId + ", countNewOrder=" + countNewOrder + "]";
	}	
}
