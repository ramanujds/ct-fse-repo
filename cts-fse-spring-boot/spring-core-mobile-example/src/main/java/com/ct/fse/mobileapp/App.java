package com.ct.fse.mobileapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ct.fse.mobileapp.sim.AirtelSim;
import com.ct.fse.mobileapp.sim.Sim;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
    	
    	
    	ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
    	Mobile m1=(Mobile)context.getBean("mobile");
    	m1.browseInternet();
    	m1.makeACall();
    	
    }
}
