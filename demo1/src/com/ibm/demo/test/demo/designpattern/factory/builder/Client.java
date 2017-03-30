package com.ibm.demo.test.demo.designpattern.factory.builder;

public class Client {
	public static void main(String[] args) {
		AirShipBuilder builder=new LmyAirShipBuilder();
		AirShip ship=new LmyAirShipDirector(builder).directAirShip();
		System.out.println(ship.getEngine().getName());
		System.out.println(ship.getEscapeTower().getName());
		System.out.println(ship.getOrbitalModule().getName());
	}
}
