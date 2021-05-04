package com.ct.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ct.microservices.model.Coupon;
import com.ct.microservices.repository.CouponRepo;

@RestController
@RequestMapping("/coupons")
public class CouponController {

	@Autowired
	CouponRepo repo;
	
	
	
	@GetMapping("/code/{couponCode}")
	public Coupon getCoupon(@PathVariable String couponCode) {
		Coupon coupon= repo.findByCouponCode(couponCode);
		return coupon;
	}
	
	@PostMapping("/coupon")
	public Coupon addCoupon(@RequestBody Coupon coupon) {
		return repo.save(coupon);
	}
	
	
}
