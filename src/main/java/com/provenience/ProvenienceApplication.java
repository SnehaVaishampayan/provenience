package com.provenience;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ProvenienceApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ProvenienceApplication.class, args);
//		System.out.println(new com.provenience.Welcome().getWelcome());

		// Ask Spring to create object and print msg
		Welcome msg = (Welcome) context.getBean("welcome");
		System.out.println(msg);

	}
}
