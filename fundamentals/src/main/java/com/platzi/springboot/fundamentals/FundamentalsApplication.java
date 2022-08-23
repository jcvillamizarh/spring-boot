package com.platzi.springboot.fundamentals;

import com.platzi.springboot.fundamentals.bean.BeanWithDependency;
import com.platzi.springboot.fundamentals.bean.MyBean;
import com.platzi.springboot.fundamentals.bean.MyBeanWithProperties;
import com.platzi.springboot.fundamentals.component.ComponentDependency;
import com.platzi.springboot.fundamentals.pojo.User;
import com.platzi.springboot.fundamentals.repository.UserRepository;
import com.platzi.springboot.fundamentals.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentalsApplication implements CommandLineRunner {

	private final Log LOGGER = LogFactory.getLog(FundamentalsApplication.class);

	private ComponentDependency componentDependency;
	private MyBean myBean;

	private BeanWithDependency beanWithDependency;
	private MyBeanWithProperties myBeanWithProperties;

	private UserService userService;

	private User user;
	private UserRepository userRepository;
	public FundamentalsApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency,
								   MyBean myBean,
								   BeanWithDependency beanWithDependency,
								   MyBeanWithProperties myBeanWithProperties,
								   User user,
								   UserRepository userRepository,
								   UserService userService) {
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.beanWithDependency = beanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.user = user;
		this.userRepository = userRepository;
		this.userService = userService;
	}
	public static void main(String[] args) {
		SpringApplication.run(FundamentalsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		saveUsers();
		//getUserInformation();
	}

	private void saveUsers() {
		com.platzi.springboot.fundamentals.entity.User user = new com.platzi.springboot.fundamentals.entity.User("Juan Camilo", "test@mail.com", LocalDate.of(1987, 07, 19));
		com.platzi.springboot.fundamentals.entity.User user2 = new com.platzi.springboot.fundamentals.entity.User("Juan Daniel", "test1@mail.com", LocalDate.of(1987, 11, 10));
		List<com.platzi.springboot.fundamentals.entity.User> users = Arrays.asList(user, user2);
//		users.forEach(userRepository::save);
		userRepository.saveAll(users);
	}

	private void getUserInformation() {
//		LOGGER.info("Usuario: " + userRepository.findByEmail("test@mail.com").orElseThrow(() -> new RuntimeException("User not found")));
//		userRepository.findAndSort("Juan", Sort.by("id").descending())
//				.forEach(user -> LOGGER.info("User sirted" + user));
//
//		userRepository.findByName("Juan Daniel").forEach(user -> LOGGER.info("User query Method: " + user));
//		userRepository.findByNameLike("Juan%").forEach(user -> LOGGER.info("Name like: " + user));
//		userRepository.findByNameOrEmail(null, "test@mail.com").forEach(user1 -> LOGGER.info("User with or: " + user));

//		userRepository.findByBirthDateBetween(LocalDate.of(1987, 01, 01), LocalDate.of(1987,12, 01))
//				.forEach(user1 -> LOGGER.info("User dates: " + user));
//		userRepository.findByNameContainingOrderByIdDesc("Juan").forEach(user -> LOGGER.info("User: " + user));
//		LOGGER.info("user : " + userRepository.getAllByBirthDateAndEmail(LocalDate.of(1987, 07, 19), "test@mail.com").orElseThrow(
//				() -> new RuntimeException("User not found")));

		saveWithErrorTransactional();
	}

	private void saveWithErrorTransactional() {
		com.platzi.springboot.fundamentals.entity.User test1 = new com.platzi.springboot.fundamentals.entity.User("test1", "test1@mail.com", LocalDate.now());
		com.platzi.springboot.fundamentals.entity.User test2 = new com.platzi.springboot.fundamentals.entity.User("test2", "test1@mail.com", LocalDate.now());
		com.platzi.springboot.fundamentals.entity.User test3 = new com.platzi.springboot.fundamentals.entity.User("test3", "test3@mail.com", LocalDate.now());
		com.platzi.springboot.fundamentals.entity.User test4= new com.platzi.springboot.fundamentals.entity.User("test4", "test4@mail.com", LocalDate.now());

		List<com.platzi.springboot.fundamentals.entity.User> users = Arrays.asList(test1, test2, test3, test4);

		try {
			userService.saveTransactional(users);
		} catch (Exception ex) {
			LOGGER.error("There was an error inserting the users: " + ex);
		}


		userService.getAllUsers().forEach(user -> LOGGER.info("User found: " + user));

	}

	private void exampleClasses() {
		componentDependency.greeting();
		myBean.print();
		beanWithDependency.printWithDependency();
		System.out.println(myBeanWithProperties.function());
		System.out.println(user.getEmail() + "-" + user.getPassword() + "-" + user.getAge());
		LOGGER.error("Error from application");
	}
}
