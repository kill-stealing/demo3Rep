package com.ibm.demo.test.demo.designpattern.factory.builder;

public interface AirShipBuilder {
	Engine builderEngine();
	OrbitalModule builderOrbitalModule();
	EscapeTower builderEscapeTower();
}
