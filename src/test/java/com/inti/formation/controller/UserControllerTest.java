package com.inti.formation.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inti.formation.JunitExoApplication;
import com.inti.formation.entities.User;
import com.inti.formation.entities.UserDaoTest;
import com.inti.formation.metier.UserService;

@WebAppConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JunitExoApplication.class)
public class UserControllerTest {
	@Autowired
	WebApplicationContext webApplicationContext;
	
	protected MockMvc mvc;
	protected String uri;
	
	@Before
	public void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		MockitoAnnotations.initMocks(this);
	}
	
	@Mock
	private UserService mockUserService;
	
	@Autowired
	private UserService userService;
	private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoTest.class);
	
	public UserControllerTest() {
		super();
		this.uri = "/user";
	}
	
//	@Test
//	public void getAllEntityList() {
//		MvcResult mvcResult;
//		try {
//			LOGGER.info("---Testing-A---");
//			userService.addUser(new User(2, "dalii"));
//			LOGGER.info("---Testing-A---");
//			mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri + "/all").accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
//			LOGGER.info("---Testing-A---");
//			int status = mvcResult.getResponse().getStatus();
//			LOGGER.info("---Testing-A---");
//			assertEquals(200, status);
//			LOGGER.info("---Testing-A---");
//			String content = mvcResult.getResponse().getContentAsString();
//			LOGGER.info("---Testing-A---");
//			User[] userList = this.mapFromJson(content, User[].class);
//			LOGGER.info("---Testing-A---");
//			assertTrue(userList.length > 0);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}		
//	}
//	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Test
	public void createEntity() {
		User user = new User(50, "sala7");
		MvcResult mvcResult;
		
		try {
			LOGGER.info("---Testing-B---");
			String inputJson = this.mapToJson(user);
			mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri + "/adduser")
					.contentType(MediaType.APPLICATION_JSON_VALUE)
					.content(inputJson)).andReturn();
			Mockito.verify(mvc).perform(MockMvcRequestBuilders.post(uri + "/adduser")
					.contentType(MediaType.APPLICATION_JSON_VALUE)
					.content(inputJson));
			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			Mockito.when(mockUserService.getUserById(50)).thenReturn(user);
			User userFound = mockUserService.getUserById(50);
			assertEquals(userFound.getUserName(), user.getUserName());
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
		
	
	protected final String mapToJson(Object obj) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(obj);
	}
	
	protected final <T> T mapFromJson(String json, Class<T> c) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(json, c);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
