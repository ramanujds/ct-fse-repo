package com.ct.fse.mobileapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.ct.fse.mobileapp.sim.AirtelSim;
import com.ct.fse.mobileapp.sim.JIOSim;

@Configuration
@ComponentScan(basePackages = {"com.ct.fse.mobileapp"})
@PropertySource("mobile.properties")
public class MobileConfig {
	
}
