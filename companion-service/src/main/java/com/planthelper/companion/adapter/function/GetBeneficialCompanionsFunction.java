package com.planthelper.companion.adapter.function;

import com.planthelper.companion.util.exception.MethodNotImplementedException;
import java.util.function.Function;
import org.springframework.stereotype.Component;

@Component
public class GetBeneficialCompanionsFunction
	implements Function<PlantCompanionInputDTO, PlantCompanionOutputDTO> {

	@Override
	public PlantCompanionOutputDTO apply(
		PlantCompanionInputDTO plantCompanionInputDTO
	) {
		throw new MethodNotImplementedException();
	}
}
