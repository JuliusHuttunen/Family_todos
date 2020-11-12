package com.example.familycalendar;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
			
			//lisätään kuukaudet monthrepositoryyn:
			mrepository.save(new Month("Tammikuu"));
			mrepository.save(new Month("Helmikuu"));
			mrepository.save(new Month("Maaliskuu"));
			mrepository.save(new Month("Huhtikuu"));
			mrepository.save(new Month("Toukokuu"));
			mrepository.save(new Month("Kesäkuu"));
			mrepository.save(new Month("Heinäkuu"));
			mrepository.save(new Month("Elokuu"));
			mrepository.save(new Month("Syyskuu"));
			mrepository.save(new Month("Lokakuu"));
			mrepository.save(new Month("Marraskuu"));
			mrepository.save(new Month("Joulukuu"));
			
			//lisätään käyttäjät userrepositoryyn:
			User user1 = new User("Julius", "$2a$10$USgzV8tM1Xf.qGtWmSLeX.Ofi.ztHHsTjuWYMD/Z49OnVcnJXQ12G", "ADMIN");
			User user2 = new User("Jutta", "$2a$10$sX6m4pxyE8QSqxaBhPIPROVi7OU9vU7Wr/6o5xrCn19WZit9i7H3O", "USER");
			User user3 = new User("Sade", "", "USER");
			urepository.save(user1);
			urepository.save(user2);
			urepository.save(user3);
			
			//käännetään salasanat:
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String password = "21342qxv";
			String encodedPassword = passwordEncoder.encode(password);
			System.out.println();
			System.out.println("Password is         : " + password);
			System.out.println("Encoded Password is : " + encodedPassword);
			
			BCryptPasswordEncoder passwordEncoder2 = new BCryptPasswordEncoder();
			String password2 = "2310sade";
			String encodedPassword2 = passwordEncoder2.encode(password2);
			System.out.println();
			System.out.println("Password is         : " + password2);
			System.out.println("Encoded Password is : " + encodedPassword2);
			
		};
	};

	}

