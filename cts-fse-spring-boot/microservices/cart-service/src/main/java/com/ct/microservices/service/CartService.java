package com.ct.microservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ct.microservices.model.CartDetails;
import com.ct.microservices.model.Coupon;
import com.ct.microservices.model.MenuItem;
import com.ct.microservices.util.CouponServiceProxy;

@Service
public class CartService {
	
	@Autowired
	CouponServiceProxy proxy;
	
	@Autowired
	private RestTemplate rt;
	@Value("${coupon_service_host:localhost}")
	private String couponServiceHost;
	@Value("${menu_item_service_host:localhost}")
	private String menuItemServiceHost;
	
	@Value("${coupon_service_port:5200}")
	private String couponServicePort;
	@Value("${menu_item_service_port:5100}")
	private String menuItemServicePort;
	

	public CartDetails getCartDetails(long itemId, String couponCode) {

		MenuItem menuItem=rt.getForObject("http://"+menuItemServiceHost+":"+menuItemServicePort+"/menu-item/items/"+itemId, MenuItem.class);
		Coupon coupon=rt.getForObject("http://"+couponServiceHost+":"+couponServicePort+"/coupons/code/"+couponCode, Coupon.class);
		
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

	}
	
private void addCouponToCart(CartDetails cartDetails,Coupon coupon) {
		
		cartDetails.setCouponCode(coupon.getCouponCode());
		cartDetails.setDiscount(coupon.getDiscount());
		cartDetails.setMaxDiscount(coupon.getMaxDiscount());
	
	}
	

private double calculateDiscount(double price, double discount) {
	return price*(discount/100.0);
}
	


	
}
