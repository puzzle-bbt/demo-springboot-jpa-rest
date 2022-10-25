package ch.puzzle.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.Clock;

@EnableJpaAuditing
@SpringBootApplication
public class DemoSpringbootJpaRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringbootJpaRestApplication.class, args);
	}
}
