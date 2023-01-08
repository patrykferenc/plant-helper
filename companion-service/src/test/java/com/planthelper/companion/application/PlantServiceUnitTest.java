package com.planthelper.companion.application;

import com.planthelper.companion.application.exceptions.PlantNotFoundException;
import com.planthelper.companion.domain.model.PlantStubs;
import com.planthelper.companion.domain.model.value.Name;
import com.planthelper.companion.domain.port.PlantRepository;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PlantServiceUnitTest {

	private PlantService plantService;

	@Mock
	private PlantRepository plantRepository;

	@BeforeEach
	void setUp() {
		plantService = new PlantService(plantRepository);
	}

	@Test
	void shouldReturnPlantCompanions() {
		// given plant with that name exists in the database
		Mockito
			.when(plantRepository.getPlantByName(Name.of("Tomato")))
			.thenReturn(Optional.of(PlantStubs.getSamplePlant()));

		// when
		final var nameOfPlantToFind = Name.of("Tomato");

		final var plantReceived = plantService.getPlantByName(nameOfPlantToFind);

		Assertions.assertThat(plantReceived).isEqualTo(PlantStubs.getSamplePlant());
	}

	@Test
	void shouldThrowException_ifPlantWithThatNameDoesNotExist() {
		// given plant with that name does not exist in the database
		Mockito
			.when(plantRepository.getPlantByName(Name.of("Tomato")))
			.thenReturn(Optional.empty());

		// when
		final var nameOfPlantToFind = Name.of("Tomato");

		// then
		Assertions
			.assertThatThrownBy(() -> plantService.getPlantByName(nameOfPlantToFind))
			.isInstanceOf(PlantNotFoundException.class)
			.hasMessage("Plant with name Tomato could not be found.");
	}
}
