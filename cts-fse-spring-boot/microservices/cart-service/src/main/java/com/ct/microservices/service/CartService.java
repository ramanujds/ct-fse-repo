package com.ct.microservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ct.microservices.model.CartDetails;
import com.ct.microservices.model.Coupon;
import com.ct.microservices.model.MenuItem;

@Service
public class CartService {
	
	@Autowired
	private RestTemplate rt;

	public CartDetails getCartDetails(long itemId, String couponCode) {

		MenuItem menuItem=rt.getForObject("http://menu-item-service/menu-item/items/"+itemId, MenuItem.class);
		Coupon coupon=rt.getForObject("http://coupon-service/coupons/code/"+couponCode, Coupon.class);
		
		CartDetails cartDetails=new CartDetails();
		addMenuItemToCart(cartDetails,menuItem);
		addCouponToCart(cartDetails,coupon);
		double appliedDiscount=calculateDiscount(cartDetails.getPrice(), cartDetails.getDiscount());
		appliedDiscount=appliedDiscount<cartDetails.getMaxDiscount()?appliedDiscount:cartDetails.getMaxDiscount();
		double finalPrice=cartDetails.getPrice()-appliedDiscount;
		cartDetails.setFinalPrice(finalPrice);
	
		return cartDetails;
	}

	private void addMenuItemToCart(CartDetails cartDetails,MenuItem menuItem) {
		
		cartDetails.setMenuItemId(menuItem.getMenuItemId());
		cartDetails.setItemName(menuItem.getItemName());
		cartDetails.setPrice(menuItem.getPrice());
		cartDetails.setMenuItemServicePort(menuItem.getPort());
	}
	
private void addCouponToCart(CartDetails cartDetails,Coupon coupon) {
		
		cartDetails.setCouponCode(coupon.getCouponCode());
		cartDetails.setDiscount(coupon.getDiscount());
		cartDetails.setMaxDiscount(coupon.getMaxDiscount());
		cartDetails.setCouponServicePort(coupon.getPort());
	}
	

private double calculateDiscount(double price, double discount) {
	return price*(discount/100.0);
}
	


	
}
