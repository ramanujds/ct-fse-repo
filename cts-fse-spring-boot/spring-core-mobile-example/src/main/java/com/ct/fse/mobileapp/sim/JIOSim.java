package com.ct.fse.mobileapp.sim;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


@Component("jio")
@Lazy
public class JIOSim implements Sim {
	
	public JIOSim() {
		System.out.println("JIO Sim Created..");
	}

	public void call() {
		System.out.println("Calling with JIO...");
	}
	
	public void browseInternet() {
		System.out.println("Browsing Internet with JIO...");
	}
	
	
}
