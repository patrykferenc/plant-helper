package com.planthelper.companion.adapter.function;

import com.microsoft.azure.functions.ExecutionContext;
import java.util.logging.Logger;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.cloud.function.adapter.azure.FunctionInvoker;

@Disabled
class PlantCompanionHandlerIntegrationTest {

	@Test
	void shouldExecuteFunction() {
		FunctionInvoker<PlantCompanionInputDTO, PlantCompanionOutputDTO> functionInvoker = new FunctionInvoker<>(
			GetBeneficialCompanionsFunction.class
		);

		final var inputDto = new PlantCompanionInputDTO();

		final var returnedDto = functionInvoker.handleRequest(
			inputDto,
			getMockedExecutionContextForClassAndWithName()
		);

		functionInvoker.close();

		Assertions.assertThat(returnedDto).isNotNull();
	}

	private static ExecutionContext getMockedExecutionContextForClassAndWithName() {
		return new ExecutionContext() {
			@Override
			public Logger getLogger() {
				return Logger.getLogger(
					PlantCompanionHandlerIntegrationTest.class.getName()
				);
			}

			@Override
			public String getInvocationId() {
				return "1";
			}

			@Override
			public String getFunctionName() {
				return "getBeneficialCompanionsFunction";
			}
		};
	}
}
