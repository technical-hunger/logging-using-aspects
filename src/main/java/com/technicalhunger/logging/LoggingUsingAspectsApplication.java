package com.technicalhunger.logging;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class LoggingUsingAspectsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoggingUsingAspectsApplication.class, args);
	}

}
