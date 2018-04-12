package com.datarepublic.simplecab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.datarepublic.simplecab.repository")
@ComponentScan(basePackages = {"com.datarepublic"})
public class Server {

	public static void main(String[] args) {
		SpringApplication.run(Server.class, args);
	}
}
