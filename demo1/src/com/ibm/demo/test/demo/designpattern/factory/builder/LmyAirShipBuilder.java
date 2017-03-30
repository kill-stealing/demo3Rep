package com.ibm.demo.test.demo.designpattern.factory.builder;

public class LmyAirShipBuilder implements AirShipBuilder{

	@Override
	public Engine builderEngine() {
		return new Engine("刘氏发动机");
	}

	@Override
	public OrbitalModule builderOrbitalModule() {
		// TODO Auto-generated method stub
		return new OrbitalModule("刘氏轨道舱");
	}

	@Override
	public EscapeTower builderEscapeTower() {
		// TODO Auto-generated method stub
		return new EscapeTower("刘氏逃生舱");
	}

}
