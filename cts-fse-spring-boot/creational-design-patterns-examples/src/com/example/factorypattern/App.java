package com.example.factorypattern;

public class App {

	public static void main(String[] args) {
		
		Mobile mobile=new Mobile();
		SimFactory simFactory=new SimFactory();
		Sim sim=simFactory.getSim("airtel");
		sim.setDataSpeed(5.2);
		mobile.setSim(sim);
		
		mobile.browse();
		
		sim=simFactory.getSim("airtel");
		mobile.setSim(sim);
		mobile.browse();

	}

}
