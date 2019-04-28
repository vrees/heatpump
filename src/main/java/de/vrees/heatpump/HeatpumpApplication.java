package de.vrees.heatpump;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"de.vrees.heatpump"})
public class HeatpumpApplication {

	public static void main(String[] args) {
		SpringApplication.run(HeatpumpApplication.class, args);
	}



}
