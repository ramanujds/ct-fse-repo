package com.ct.fse.mobileapp;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ct.fse.mobileapp.sim.AirtelSim;
import com.ct.fse.mobileapp.sim.JIOSim;
import com.ct.fse.mobileapp.sim.Sim;
@Component
@Scope("prototype")
public class Mobile implements InitializingBean, DisposableBean {
	
	@Value("${mobile.brand-name}")
	String brandName;
	
	@Value("${mobile.model}")
	String model;
	
	@Value("${mobile.ram}")
	int ramSize;
	
	
	
	@Autowired
	@Qualifier("airtel")
	Sim sim;
	
	@PostConstruct
	public void init() {
		System.out.println("Mobile initialized..");
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Mobile initialized Again..");
		
	}
	
	
	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getRamSize() {
		return ramSize;
	}

	public void setRamSize(int ramSize) {
		this.ramSize = ramSize;
	}

	public Mobile() {
		System.out.println("Mobile Created..");
	}
	
	public Sim getSim() {
		return sim;
	}

	public void setSim(Sim sim) {
		this.sim = sim;
	}

	public void makeACall() {
		sim.call();
	}
	
	public void browseInternet() {
		sim.browseInternet();
	}

	@Override
	public String toString() {
		return "Mobile [brandName=" + brandName + ", model=" + model + ", ramSize=" + ramSize + ", sim=" + sim + "]";
	}

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		
	}

	
	
	

}
