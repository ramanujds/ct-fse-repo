package com.example.factorypattern;

public class Mobile {

	private Sim sim;
	
	
	public void setSim(Sim sim) {
		this.sim = sim;
	}

	public void call() {
		sim.call();
	}
	
	public void browse() {
		sim.browse();
	}
	
	
}
