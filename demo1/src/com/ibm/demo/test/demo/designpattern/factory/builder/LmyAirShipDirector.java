package com.ibm.demo.test.demo.designpattern.factory.builder;

public class LmyAirShipDirector implements AirShipDirector{
	private AirShipBuilder builder;
	
	public LmyAirShipDirector(AirShipBuilder builder) {
		this.builder=builder;
	}

	@Override
	public AirShip directAirShip() {
		Engine e=builder.builderEngine();
		OrbitalModule o=builder.builderOrbitalModule();
		EscapeTower es=builder.builderEscapeTower();
		AirShip ship=new AirShip();
		ship.setEngine(e);
		ship.setEscapeTower(es);
		ship.setOrbitalModule(o);
		return ship;
	}

}
