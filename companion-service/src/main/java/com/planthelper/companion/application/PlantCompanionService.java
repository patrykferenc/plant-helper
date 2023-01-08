package com.planthelper.companion.application;

import com.planthelper.companion.domain.model.Plant;
import com.planthelper.companion.domain.model.value.Name;
import com.planthelper.companion.domain.port.BeneficialPlantCompanionRepository;
import com.planthelper.companion.domain.port.HarmfulPlantCompanionRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PlantCompanionService {

	private final PlantService plantService;

	private final BeneficialPlantCompanionRepository beneficialPlantCompanionRepository;

	private final HarmfulPlantCompanionRepository harmfulPlantCompanionRepository;

	public List<Plant> getBeneficialCompanionsFor(Name plantName) {
		final var plant = plantService.getPlantByName(plantName);

		return beneficialPlantCompanionRepository.getBeneficialCompanionsFor(
			plant.getCommonName()
		);
	}

	public List<Plant> getHarmfulCompanionsFor(Name plantName) {
		final var plant = plantService.getPlantByName(plantName);

		return harmfulPlantCompanionRepository.getHarmfulCompanionsFor(
			plant.getCommonName()
		);
	}
}
