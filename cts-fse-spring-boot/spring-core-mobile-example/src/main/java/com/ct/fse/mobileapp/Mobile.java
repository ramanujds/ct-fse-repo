package com.ct.fse.mobileapp;

import com.ct.fse.mobileapp.sim.AirtelSim;
import com.ct.fse.mobileapp.sim.JIOSim;
import com.ct.fse.mobileapp.sim.Sim;

public class Mobile {
	
	Sim sim;
	
	public Mobile() {
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
	

}
