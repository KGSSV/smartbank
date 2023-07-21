package com.brillio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
@ComponentScan(basePackages = "com.brillio")
public class SmartBankSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartBankSpringBootApplication.class, args);
	}

}
