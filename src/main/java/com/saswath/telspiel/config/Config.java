package com.saswath.telspiel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.saswath.telspiel.serviceImpl.SaswathServiceImpl;

@Configuration
public class Config {

	@Bean
	public SaswathServiceImpl saswathServiceImpl() {
		return new SaswathServiceImpl();
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
