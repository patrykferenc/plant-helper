package com.planthelper.companion.domain.port;

import com.planthelper.companion.domain.model.Plant;
import com.planthelper.companion.domain.model.value.Name;
import java.util.List;

public interface HarmfulPlantCompanionRepository {
	List<Plant> getHarmfulCompanionsFor(Name plantName);
}
