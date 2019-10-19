package com.inti.formation.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.inti.formation.JunitExoApplication;
import com.inti.formation.dao.UserDao;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JunitExoApplication.class)
public class UserDaoTest {

	@Autowired
	private UserDao userDao;
	private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoTest.class);
	
	@Test
	public void givenEntityRepository() {
		LOGGER.info("Testing");
		System.out.println(userDao);
		User addedUser = userDao.addUser(new User(10, "dalii"));
		LOGGER.info("Searching");
		User foundUser = userDao.findById(addedUser.getId());
		LOGGER.info("verifying");
		assertNotNull(foundUser);
		assertEquals(addedUser.getUserName(), foundUser.getUserName());
		LOGGER.info("verified");
		
	}
	
	
}
