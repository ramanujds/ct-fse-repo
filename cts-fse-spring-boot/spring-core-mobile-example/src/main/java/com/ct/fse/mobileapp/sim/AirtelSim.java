package com.ct.fse.mobileapp.sim;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("airtel")
@Scope("prototype")
//@Lazy
public class AirtelSim implements Sim {
	
	public AirtelSim() {
		System.out.println("Airtel Sim Created..");
	}
	
	
	public AirtelSim(int value) {
		// TODO Auto-generated constructor stub
	}

	public void call() {
		System.out.println("Calling with Airtel...");
	}
	
	public void browseInternet() {
		System.out.println("Browsing Internet with Airtel...");
	}
	
	
}
