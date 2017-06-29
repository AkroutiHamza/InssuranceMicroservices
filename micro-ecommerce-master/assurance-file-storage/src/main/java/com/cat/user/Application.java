package com.cat.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

import com.cat.user.domain.User;

@SpringBootApplication
@EnableJpaRepositories
@Import(RepositoryRestMvcConfiguration.class)
// @EnableDiscoveryClient
public class Application

{
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

  	@Configuration
	static class RestMvc extends RepositoryRestMvcConfiguration {

		@Override
		protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
			config.exposeIdsFor(User.class);
		}

	}

}
