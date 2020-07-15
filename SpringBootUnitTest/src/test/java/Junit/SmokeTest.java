package Junit;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import SpringBootUnitTest.controller.HomeController;

@AutoConfigureMockMvc
@SpringBootTest(classes = HomeController.class)
public class SmokeTest 
{

	@Autowired
	private HomeController controller;

	@Test
	public void contexLoads() throws Exception
	{
		assertThat(controller).isNotNull();
	}
}