package com.planthelper.companion.domain.model;

import com.planthelper.companion.domain.model.value.Name;

public class PlantStubs {

	public static Plant getSamplePlant() {
		return Plant
			.builder()
			.commonName(Name.of("Tomato"))
			.latinName(Name.of("Solanum lycopersicum"))
			.type(PlantType.VEGETABLE)
			.build();
	}

	public static Plant getSamplePlantWithCommonName(String commonName) {
		return Plant
			.builder()
			.commonName(Name.of(commonName))
			.latinName(Name.of("Sussus amogus"))
			.type(PlantType.VEGETABLE)
			.build();
	}
}
