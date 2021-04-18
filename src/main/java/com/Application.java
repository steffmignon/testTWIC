package com;


import java.util.logging.LogManager;
import java.util.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class,args);
		/*
		//final Logger logger = LogManager.getLogger(Application.class);
		Logger logger = LogManager.getLogger(Application.class.getName());
		logger.log(null, "Application demaree");
		*/
		System.out.println("Application demaree");

	}

}
