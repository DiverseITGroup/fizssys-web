package com.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import lombok.Data;

@SpringBootApplication
public class FizssysWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(FizssysWebApplication.class, args);
	}

	@Bean
	public DigConfiguration digConfiguration() {
		return new DigConfiguration();
	}

	@Component
	@ConfigurationProperties(prefix = "app.dig")
	@Data
	public static class DigConfiguration {
		private String uri;
	}
}
