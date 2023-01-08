package com.planthelper.companion.domain.port;

import com.planthelper.companion.domain.model.Plant;
import com.planthelper.companion.domain.model.value.Name;
import java.util.Optional;

public interface PlantRepository {
	Optional<Plant> getPlantByName(Name plantName);
}
