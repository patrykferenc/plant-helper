package com.planthelper.companion.domain.model.value;

import lombok.Value;

@Value(staticConstructor = "of")
public class Name {

	String value;
}
