package com.ct.microservices.util;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ct.microservices.model.Coupon;
@Component
@FeignClient("http://coupon-service")
@RibbonClient("http://coupon-service")
public interface CouponServiceProxy {

	@GetMapping("/coupons/code/{couponCode}")
	public Coupon getCoupon(@PathVariable String couponCode);
	
	
}
