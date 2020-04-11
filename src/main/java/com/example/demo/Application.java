package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.app.CountriesGraph;
import com.example.demo.app.Country;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
    
    @Bean
    public CommandLineRunner run(CountriesGraph countriesGraph) {
        return (String[] args) -> {
        	log.debug("Countries Graph: " + countriesGraph);
        };
    }
}
