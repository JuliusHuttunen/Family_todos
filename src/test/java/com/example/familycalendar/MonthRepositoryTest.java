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

import com.example.familycalendar.domain.Month;
import com.example.familycalendar.domain.MonthRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class MonthRepositoryTest {
	
	@Autowired
	private MonthRepository repository;
	
	//Kuukausia on 12
	@Test
	public void repoSizeShouldBeTwelve() {
        List<Month> months = (List<Month>) repository.findAll();
        
        assertThat(months).hasSize(12);
    }
	
	//Tyhjennetään Repository
	@Test
    public void deleteMonth() {
        
    	repository.deleteAll();
    	assertThat(repository.count()).isEqualTo(0);
    	
    }    

}

