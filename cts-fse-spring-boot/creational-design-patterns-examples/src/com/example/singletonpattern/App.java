package com.example.singletonpattern;

public class App {

	public static void main(String[] args) {
		
		Car car=Car.getCarObj();
		car.showCar();

	}

}
