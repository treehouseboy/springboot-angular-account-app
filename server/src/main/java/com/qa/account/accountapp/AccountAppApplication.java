package com.qa.account.accountapp;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccountAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountAppApplication.class, args);
	}
	
	@Bean
    ApplicationRunner init(AccountRepository repository) {
        return args -> {
            Stream.of("Matt", "Jimmy", "Pamela", "Larry", "Ben",
                      "Anna", "Tilly", "Fred", "Robert").forEach(name -> {
                Account account = new Account();
                account.setName(name);
                repository.save(account);
            });
            repository.findAll().forEach(System.out::println);
        };
    }
}
