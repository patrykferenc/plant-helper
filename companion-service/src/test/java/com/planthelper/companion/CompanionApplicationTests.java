package com.planthelper.companion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CompanionApplicationTests {

	//	@Disabled("TODO#2: To be removed")
	@Test
	void contextLoads() {
		// just to make sure that the context loads
		Assertions.assertTrue(true);
	}
}
