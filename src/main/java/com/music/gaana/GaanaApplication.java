package com.music.gaana;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.music.gaana.filter.AppFilter;

@SpringBootApplication
public class GaanaApplication {

	public static void main(String[] args) {
		SpringApplication.run(GaanaApplication.class, args);
	}

	// create appfilter bean for security
	@Bean
	public AppFilter appFilter() {
		return new AppFilter();
	}

}
