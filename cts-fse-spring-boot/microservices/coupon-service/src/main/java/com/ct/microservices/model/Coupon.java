package com.ct.microservices.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Coupon {

	@Id @GeneratedValue
	private long id;
	
	private String couponCode;
	private double discount;
	private double maxDiscount;
	
	
	
	
}
