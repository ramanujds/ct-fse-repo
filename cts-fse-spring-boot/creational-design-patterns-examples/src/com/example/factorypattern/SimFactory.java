package com.example.factorypattern;

public class SimFactory {

	public Sim getSim(String provider) {
		if(provider.equals("airtel")) {
			return new AirtelSim();
		}
		
		else if(provider.equals("vi")) {
			return new ViSim();
		}
		return null;
	}
	
	
}
