package com.ct.microservice.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.ct.microservice.model.AuthToken;
import com.ct.microservice.model.CartDetails;
import com.ct.microservice.model.Credentials;

@Controller
public class FoodAppController implements ErrorController {

	@Autowired
	RestTemplate rt;
	
	@Value("${cart-service.uri}")
	private String uri;
	
	
	
	@GetMapping("/get-food-info")
	public String getFoodInfo(@RequestParam("item-id") int itemId,@RequestParam("coupon-code") String couponCode, Model m) {
		try {
		CartDetails cartEntity=rt.getForObject(uri+"/cart/item/"+itemId+"/coupon/"+couponCode, CartDetails.class);
		
		}
		catch (HttpClientErrorException e) {
			m.addAttribute("code",e.getRawStatusCode());
			m.addAttribute("message", e.getStatusCode());
			return "error";
		}
		return "show-cart.jsp";
	}
	
	
	
	@PostMapping("/login")
	public String login(@ModelAttribute Credentials cred, HttpSession session) {
		AuthToken token=rt.postForObject(uri+"/public/authenticate/", cred, AuthToken.class);
		session.setAttribute("token", token.getJwtToken());
		return "home.jsp";
	}
	
	@Override
	public String getErrorPath() {
		
		return "error";
	}
	
	@GetMapping("/error")
	public String getErrorPage(HttpServletRequest request) {
		
		return "error.jsp";
	}
	
}
