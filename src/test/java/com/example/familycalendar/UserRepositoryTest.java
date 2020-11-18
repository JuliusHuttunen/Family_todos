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

import com.example.familycalendar.domain.User;
import com.example.familycalendar.domain.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository repository;
	
	//Vain yksi käyttäjistä on admin
	@Test
	public void repoShouldOnlyHaveOneAdmin() {
        List<User> users = repository.findByRole("ADMIN");
        
        assertThat(users).hasSize(1);
        assertThat(users.get(0).getId()).isEqualTo(1);
    }

}
