package com.ct.microservices.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDetails {

	private long menuItemId;
	private String itemName;
	private double price;
	private String couponCode;
	private double discount;
	private double maxDiscount;
	private double finalPrice;
	private int couponServicePort;
	private int menuItemServicePort;
	
	
}
