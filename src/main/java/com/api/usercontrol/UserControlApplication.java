package com.api.usercontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class UserControlApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserControlApplication.class, args);
	}	

}
