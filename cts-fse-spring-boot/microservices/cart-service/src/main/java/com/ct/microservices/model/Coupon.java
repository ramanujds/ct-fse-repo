package com.ct.microservices.model;

import java.time.LocalDate;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coupon {


	private long id;
	
	private String couponCode;
	private double discount;
	private double maxDiscount;

	
	
}
