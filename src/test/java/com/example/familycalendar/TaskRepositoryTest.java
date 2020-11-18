package com.example.familycalendar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.familycalendar.domain.Task;
import com.example.familycalendar.domain.TaskRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class TaskRepositoryTest {
		
		@Autowired
		private TaskRepository repository;
		
		//Etsitään tehtävää kuvauksen perusteella
		@Test
		public void findByDescShouldReturnTask() {
	        List<Task> tasks = repository.findByDescription("Takaisin kotiin");
	        
	        assertThat(tasks).hasSize(1);
	        assertThat(tasks.get(0).getId()).isEqualTo(90);
	    }

	}
