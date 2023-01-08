package com.planthelper.companion.domain.model;

import com.planthelper.companion.domain.model.value.Name;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@Builder
public class Plant {

	Name commonName;

	@EqualsAndHashCode.Exclude
	Name latinName;

	PlantType type;
}
