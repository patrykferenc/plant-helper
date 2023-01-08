package com.planthelper.companion.domain.model;

import com.planthelper.companion.domain.model.value.Name;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PlantUnitTest {

	private static Stream<Arguments> testEqualityArguments() {
		return Stream.of(
			Arguments.of(
				PlantStubs.getSamplePlant(),
				PlantStubs.getSamplePlant(),
				true
			),
			Arguments.of(
				PlantStubs.getSamplePlant(),
				new Plant(
					PlantStubs.getSamplePlant().getCommonName(),
					PlantStubs.getSamplePlant().getLatinName(),
					PlantType.VEGETABLE
				),
				true
			),
			Arguments.of(
				PlantStubs.getSamplePlant(),
				new Plant(
					PlantStubs.getSamplePlant().getCommonName(),
					PlantStubs.getSamplePlant().getLatinName(),
					PlantType.FRUIT
				),
				false
			),
			Arguments.of(
				PlantStubs.getSamplePlant(),
				new Plant(
					PlantStubs.getSamplePlant().getCommonName(),
					Name.of("Different scientific name"),
					PlantType.VEGETABLE
				),
				true
			)
		);
	}

	@ParameterizedTest
	@MethodSource("testEqualityArguments")
	void shouldBeEqual_whenCommonNameIsTheSame(
		Plant plant1,
		Plant plant2,
		boolean expectedResult
	) {
		// given

		// when
		boolean resultOfFirstComparison = plant1.equals(plant2);
		boolean resultOfSecondComparison = plant2.equals(plant1);

		// then
		Assertions.assertThat(resultOfFirstComparison).isEqualTo(expectedResult);
		Assertions.assertThat(resultOfSecondComparison).isEqualTo(expectedResult);
	}
}
