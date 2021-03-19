package com.example.factorypattern;

public class ViSim implements Sim {

	private double speed;

	@Override
	public void call() {
		System.out.println("Calling with VI");

	}

	@Override
	public void browse() {
		System.out.println("Browsing with VI:: Speed - "+speed+" mb/s");

	}
	
	@Override
	public void setDataSpeed(double speed) {
		this.speed=speed;
		
	}

}
