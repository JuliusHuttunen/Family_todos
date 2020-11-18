package com.example.familycalendar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.familycalendar.controller.CalendarController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FamilycalendarApplicationTests {

	@Autowired
	private CalendarController controller;
	
	//Controller-luokka latautuu
	@Test
	void contextLoads() throws Exception {
			assertThat(controller).isNotNull();
	}

}
