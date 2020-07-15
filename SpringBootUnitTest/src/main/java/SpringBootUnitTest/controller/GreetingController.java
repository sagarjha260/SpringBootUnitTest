package SpringBootUnitTest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import SpringBootUnitTest.service.GreetingService;

@RestController
public class GreetingController
{

	private final GreetingService service;

	public GreetingController(GreetingService service) 
	{
		this.service = service;
	}

	@RequestMapping("/greeting")
	public @ResponseBody String greeting() 
	{
		return service.greet();
	}

}