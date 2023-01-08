package com.planthelper.companion.application;

import com.planthelper.companion.application.exceptions.PlantNotFoundException;
import com.planthelper.companion.domain.model.Plant;
import com.planthelper.companion.domain.model.value.Name;
import com.planthelper.companion.domain.port.PlantRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PlantService {

	private final PlantRepository plantRepository;

	public Plant getPlantByName(Name plantName) {
		return plantRepository
			.getPlantByName(plantName)
			.orElseThrow(() -> new PlantNotFoundException(plantName));
	}
}
