package com.coffeeshop.CoffeeShop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Items {
	
	private String itemName;
	private String itemType;
	private String itemPrice;
	private String itemQuant;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long itemID;
	
	public Items() {
		
	}
	
	

	public Items(long itemID, String itemName, String itemType, String itemPrice, String itemQuant) {
		super();
		this.itemID = itemID;
		this.itemName = itemName;
		this.itemType = itemType;
		this.itemPrice = itemPrice;
		this.itemQuant = itemQuant;
	}
	
	public Items(String itemName, String itemType, String itemPrice, String itemQuant) {
		super();
		this.itemName = itemName;
		this.itemType = itemType;
		this.itemPrice = itemPrice;
		this.itemQuant = itemQuant;
	}

	public long getItemID() {
		return itemID;
	}



	public void setItemID(long itemID) {
		this.itemID = itemID;
	}



	public String getItemQuant() {
		return itemQuant;
	}

	public void setItemQuant(String itemQuant) {
		this.itemQuant = itemQuant;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}



	@Override
	public String toString() {
		return "itemID=" + itemID +"itemName=" + itemName + ", itemType=" + itemType + ", itemPrice=" + itemPrice + ", itemQuant="
				+ itemQuant;
	}
	
}
