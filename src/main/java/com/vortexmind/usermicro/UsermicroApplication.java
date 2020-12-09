package com.vortexmind.usermicro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.vortexmind")
public class UsermicroApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsermicroApplication.class, args);
	}

}
