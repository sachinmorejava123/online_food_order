package com.nacre.ofo.dto;

import java.io.Serializable;
import java.sql.Blob;

import javax.servlet.http.Part;

public class ItemsDto implements Serializable {	
	private static final long serialVersionUID = 7835646234663589934L;
	
	private int itemId;
	private String itemName;
	private int itemPrice;
	private int deliveryCharge;
	private float discount;
	private float totalAmount;
	private String itemStatus;
	private Part itemImage;
	private Blob itemsImage;
	
	public Blob getItemsImage() {
		return itemsImage;
	}
	public void setItemsImage(Blob itemsImage) {
		this.itemsImage = itemsImage;
	}
	public Part getItemImage() {
		return itemImage;
	}
	public void setItemImage(Part itemImage) {
		this.itemImage = itemImage;
	}
	public String getItemStatus() {
		return itemStatus;
	}
	public void setItemStatus(String itemStatus) {
		this.itemStatus = itemStatus;
	}
	public float getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}
	public int getDeliveryCharge() {
		return deliveryCharge;
	}
	public void setDeliveryCharge(int deliveryCharge) {
		this.deliveryCharge = deliveryCharge;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	
	@Override
	public String toString() {
		return "ItemsDto [itemId=" + itemId + ", itemName=" + itemName + ", itemPrice=" + itemPrice
				+ ", deliveryCharge=" + deliveryCharge + ", discount=" + discount + ", totalAmount=" + totalAmount
				+ ", itemStatus=" + itemStatus + ", itemImage=" + itemImage + ", itemsImage=" + itemsImage
				+ "]";
	}	
}
