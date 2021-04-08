package com.ct.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ct.microservices.model.Coupon;

public interface CouponRepo extends JpaRepository<Coupon, Long>{

	Coupon findByCouponCode(String couponCode);
	
	
}
