package com.example.singletonpattern;

public class Car {

	private static Car carObj=new Car();
	
	private Car() {
		// TODO Auto-generated constructor stub
	}
	
	public static Car getCarObj() {
		return carObj;
	}
	
	public void showCar() {
		System.out.println("Car Object....");
	}
	
}
