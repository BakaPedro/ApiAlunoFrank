package com.apialuno.apialuno;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class ApialunoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApialunoApplication.class, args);
	}

}
