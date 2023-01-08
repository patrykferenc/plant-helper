package com.planthelper.companion.adapter.function;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import com.planthelper.companion.util.exception.MethodNotImplementedException;
import java.util.Optional;
import org.springframework.cloud.function.adapter.azure.FunctionInvoker;

@SuppressWarnings("unused")
public class PlantCompanionHandler
	extends FunctionInvoker<PlantCompanionInputDTO, PlantCompanionOutputDTO> {

	@FunctionName("getBeneficialCompanionsFunction")
	public HttpResponseMessage executeBeneficial(
		@HttpTrigger(
			name = "request",
			methods = { HttpMethod.POST },
			authLevel = AuthorizationLevel.ANONYMOUS
		) HttpRequestMessage<Optional<PlantCompanionInputDTO>> request,
		final ExecutionContext context
	) {
		throw new MethodNotImplementedException();
	}
}
