package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class Encrypter {
	@Bean
	public BCryptPasswordEncoder bcryptPasswordEncoder(){
	return new BCryptPasswordEncoder();
	}

}
