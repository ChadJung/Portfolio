package com.portfolio.website;

import com.portfolio.website.common.CustomBanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class WebsiteApplication {

	public static final String APPLICATION_LOCATIONS = "spring.config.location=" +
			"classpath:application.yml," +
			"optional:/app/config/website/real-application.yml";

	public static void main(String[] args) {
		new SpringApplicationBuilder(WebsiteApplication.class)
				.properties(APPLICATION_LOCATIONS)
				.banner(new CustomBanner())
				.run(args);
	}

}
