package com.example.factorypattern;

public class AirtelSim implements Sim {

	private double speed;
	
	@Override
	public void call() {
		System.out.println("Calling with Airtel");

	}

	@Override
	public void browse() {
		System.out.println("Browsing with Airtel:: Speed - "+speed+" mb/s");

	}
	
	@Override
	public void setDataSpeed(double speed) {
		this.speed=speed;
		
	}

}
