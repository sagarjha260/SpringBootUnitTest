package Junit;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import SpringBootUnitTest.controller.HomeController;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = HomeController.class, webEnvironment = WebEnvironment.RANDOM_PORT) //Note the use of webEnvironment=RANDOM_PORT to start the server with a random port 
															//(useful to avoid conflicts in test environments) and the injection of the port with @LocalServerPort.
@AutoConfigureMockMvc
public class HttpRequestTest
{
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate; //Spring Boot has automatically provided a TestRestTemplate for you. All you have to do is add @Autowired to it.

	@Test
	public void greetingShouldReturnDefaultMessage() throws Exception 
	{
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/", String.class)).contains("Hello, World");
	}
}