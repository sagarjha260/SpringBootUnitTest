package Junit;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import SpringBootUnitTest.controller.HomeController;

@AutoConfigureMockMvc
@SpringBootTest(classes = HomeController.class)
public class TestingWebApplicationTest extends TestingWebApplicationTests
{
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Before public void setup()
	{
		mockMvc =  MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void shouldReturnDefaultMessage() throws Exception 
	{
		this.mockMvc.perform(get("/"))
				.andDo(print()).andExpect(status().isOk())
		        .andExpect(content().string("Hello, World"));
	}
	
}