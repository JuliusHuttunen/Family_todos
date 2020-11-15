package com.example.familycalendar;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.familycalendar.domain.Month;
import com.example.familycalendar.domain.MonthRepository;
import com.example.familycalendar.domain.Task;
import com.example.familycalendar.domain.TaskRepository;
import com.example.familycalendar.domain.User;
import com.example.familycalendar.domain.UserRepository;

@SpringBootApplication
public class FamilycalendarApplication {

	public static void main(String[] args) {
		SpringApplication.run(FamilycalendarApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(TaskRepository trepository, MonthRepository mrepository, UserRepository urepository) {
		return(args) -> {
			
		};
	};

	}

