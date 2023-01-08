package com.planthelper.companion.application;

import com.planthelper.companion.domain.model.Plant;
import com.planthelper.companion.domain.model.PlantStubs;
import com.planthelper.companion.domain.model.value.Name;
import com.planthelper.companion.domain.port.BeneficialPlantCompanionRepository;
import com.planthelper.companion.domain.port.HarmfulPlantCompanionRepository;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PlantCompanionServiceUnitTest {

	private PlantCompanionService plantCompanionService;

	@Mock
	private BeneficialPlantCompanionRepository beneficialPlantCompanionRepository;

	@Mock
	private HarmfulPlantCompanionRepository harmfulPlantCompanionRepository;

	@Mock
	private PlantService plantService;

	@BeforeEach
	void setUp() {
		plantCompanionService =
			new PlantCompanionService(
				plantService,
				beneficialPlantCompanionRepository,
				harmfulPlantCompanionRepository
			);
	}

	@Test
	void shouldReturnListOfBeneficialCompanions_whenPlantHasCompanions() {
		// given that plant exists and has beneficial companions in the database
		final var plantToFindCompanionsFor = PlantStubs.getSamplePlant();

		final var expectedBeneficialCompanions = List.of(
			PlantStubs.getSamplePlantWithCommonName("Gurkin"),
			PlantStubs.getSamplePlantWithCommonName("Cucumber")
		);

		mockPlantServiceReturningPlantToFind(plantToFindCompanionsFor);

		mockBeneficialPlantRepositoryToReturnFor(
			plantToFindCompanionsFor.getCommonName(),
			expectedBeneficialCompanions
		);

		// when
		final var actualBeneficialCompanions = plantCompanionService.getBeneficialCompanionsFor(
			plantToFindCompanionsFor.getCommonName()
		);

		// then
		Assertions
			.assertThat(actualBeneficialCompanions)
			.isNotEmpty()
			.containsExactlyInAnyOrderElementsOf(expectedBeneficialCompanions);
	}

	private void mockPlantServiceReturningPlantToFind(
		Plant plantToFindCompanionsFor
	) {
		Mockito
			.when(
				plantService.getPlantByName(plantToFindCompanionsFor.getCommonName())
			)
			.thenReturn(plantToFindCompanionsFor);
	}

	private void mockBeneficialPlantRepositoryToReturnFor(
		Name plantToFindCompanionsFor,
		List<Plant> expectedBeneficialCompanions
	) {
		Mockito
			.when(
				beneficialPlantCompanionRepository.getBeneficialCompanionsFor(
					plantToFindCompanionsFor
				)
			)
			.thenReturn(expectedBeneficialCompanions);
	}

	@Test
	void shouldReturnEmptyList_whenPlantHasNoBeneficialCompanions() {
		// given that plant exists and has no beneficial companions in the database
		final var plantToFindCompanionsFor = PlantStubs.getSamplePlant();

		mockPlantServiceReturningPlantToFind(plantToFindCompanionsFor);

		mockBeneficialPlantRepositoryToReturnFor(
			plantToFindCompanionsFor.getCommonName(),
			List.of()
		);

		// when
		final var actualBeneficialCompanions = plantCompanionService.getBeneficialCompanionsFor(
			plantToFindCompanionsFor.getCommonName()
		);

		// then
		Assertions.assertThat(actualBeneficialCompanions).isEmpty();
	}

	@Test
	void shouldReturnListOfHarmfulCompanions_whenPlantHasCompanions() {
		// given that plant exists and has harmful companions in the database
		final var plantToFindCompanionsFor = PlantStubs.getSamplePlant();

		final var expectedBeneficialCompanions = List.of(
			PlantStubs.getSamplePlantWithCommonName("Gurkin"),
			PlantStubs.getSamplePlantWithCommonName("Cucumber")
		);

		mockPlantServiceReturningPlantToFind(plantToFindCompanionsFor);

		mockHarmfulPlantRepositoryToReturnFor(
			plantToFindCompanionsFor.getCommonName(),
			expectedBeneficialCompanions
		);

		// when
		final var actualBeneficialCompanions = plantCompanionService.getHarmfulCompanionsFor(
			plantToFindCompanionsFor.getCommonName()
		);

		// then
		Assertions
			.assertThat(actualBeneficialCompanions)
			.isNotEmpty()
			.containsExactlyInAnyOrderElementsOf(expectedBeneficialCompanions);
	}

	private void mockHarmfulPlantRepositoryToReturnFor(
		Name plantToFindCompanionsFor,
		List<Plant> expectedBeneficialCompanions
	) {
		Mockito
			.when(
				harmfulPlantCompanionRepository.getHarmfulCompanionsFor(
					plantToFindCompanionsFor
				)
			)
			.thenReturn(expectedBeneficialCompanions);
	}

	@Test
	void shouldReturnEmptyList_whenPlantHasNoHarmfulCompanions() {
		// given that plant exists and has no harmful companions in the database
		final var plantToFindCompanionsFor = PlantStubs.getSamplePlant();

		mockPlantServiceReturningPlantToFind(plantToFindCompanionsFor);

		mockHarmfulPlantRepositoryToReturnFor(
			plantToFindCompanionsFor.getCommonName(),
			List.of()
		);

		// when
		final var actualBeneficialCompanions = plantCompanionService.getHarmfulCompanionsFor(
			plantToFindCompanionsFor.getCommonName()
		);

		// then
		Assertions.assertThat(actualBeneficialCompanions).isEmpty();
	}
}
