package com.example.junitdemo.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloWordController.class)
public class HelloWordControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testHelloWorld_basic() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders
				.get("/hello-world")
				.accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().string("Hello World")).andReturn();
		//assertEquals("Hello World", result.getResponse().getContentAsString());
		
		// Use assert statements if responses are complex and check status for simple responses
	}

}
