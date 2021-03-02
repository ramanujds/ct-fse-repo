package com.ct.fse.mobileapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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
        
    	
 //    For XML Based Configuration   	
 //   	ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
  
 //    For Java Based Configuration
    	
    	ApplicationContext context=new AnnotationConfigApplicationContext(MobileConfig.class);
    	Mobile m1=(Mobile)context.getBean("mobile");
    	m1.browseInternet();
    	m1.makeACall();
    	System.out.println(m1);
    	m1.setModel("IPhone 12 Pro");
    	m1.setRamSize(6);
    	
    	Mobile m2=(Mobile)context.getBean("mobile");
    	System.out.println(m2);
    	context.getBean("mobile");
    	context.getBean("mobile");
    	
    }
}
