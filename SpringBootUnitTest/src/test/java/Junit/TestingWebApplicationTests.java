package Junit;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import SpringBootUnitTest.controller.HomeController;

@SpringBootTest(classes = HomeController.class)  //The @SpringBootTest annotation tells Spring Boot to look for a main class (one with @SpringBootApplication, for instance)
                 //and use that to start a Spring application context.
public class TestingWebApplicationTests {

	@Test
	public void contextLoads() {
	}

}