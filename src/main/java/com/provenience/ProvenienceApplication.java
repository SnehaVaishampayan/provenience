package com.provenience;

import com.provenience.project.Project;
import com.provenience.project.ProjectRepository;
import com.provenience.project.ProjectStatus;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class ProvenienceApplication {
	private static final Logger log = (Logger) LoggerFactory.getLogger(ProvenienceApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(ProvenienceApplication.class, args);
	}
}
