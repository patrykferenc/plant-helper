package com.planthelper.companion.application.exceptions;

import com.planthelper.companion.domain.model.value.Name;

public class PlantNotFoundException extends RuntimeException {

	public PlantNotFoundException(Name plantName) {
		super("Plant with name " + plantName.getValue() + " could not be found.");
	}
}
