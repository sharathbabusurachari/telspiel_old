package com.saswath.telspiel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = {"com.saswath.telspiel"})
public class TelspielApplication {

	public static void main(String[] args) {
		SpringApplication.run(TelspielApplication.class, args);
	}

}
