package com.example.microserviceexample;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(value = ApiController.class)
class MicroserviceExampleApplicationTests {
	//To improve: write tests to pass if the response is expected to fail

	@Autowired
	private MockMvc mockMvc;
	/* 
	CURL commands
	curl -X POST http://localhost:8080/registration -H 'Content-type:application/json' -d '{"username": "TestUser1", "password": "Testingg234%", "ip": "24.48.0.5"}'
	curl -X POST http://localhost:8080/registration -H 'Content-type:application/json' -d '{"username": "TestUser2", "password": "Testers234", "ip": "24.48.0.6"}'
	*/

	@Test
	void addUser() throws Exception {
		User mockUser1 = new User("CindyLou", "Passw123_", "100.42.20.5"); //Toronto
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(result.getResponse());
	}

	@Test
	void addUser2() throws Exception {
		User mockUser2 = new User("JCena", "Pass%33123", "150.107.124.0"); //Calgary
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(result.getResponse());
	}

	@Test
	void addUserNonCanadian() throws Exception {
		User mockUser3 = new User("BLYear", "Testin432#", "103.106.230.5"); //Taiwan
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(result.getResponse());
	}

	@Test
	void addUserInvalidPass1() throws Exception {
		User mockUser4 = new User("Mario", "Testerz007", "100.42.20.6"); //no special character password
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(result.getResponse());
	}

	@Test
	void addUserInvalidPass2() throws Exception {
		User mockUser5 = new User("Luigi", "Test_9", "100.42.20.7"); //short password
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(result.getResponse());
	}

	@Test
	void addUserNullIp() throws Exception {
		User mockUser6 = new User("User123", "Tester_097", null); //null IP address
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(result.getResponse());
	}

}
