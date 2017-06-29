package org.cat.europe.bulletin;

import java.io.File;
import java.io.IOException;

import org.cat.europe.bulletin.App;
import org.cat.europe.bulletin.RestService.ProfessionelRestService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**

 
 */
@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
public class App extends SpringBootServletInitializer {
	public static void main(String[] args) throws IOException {
        new File(ProfessionelRestService.uploadingdir).mkdirs();
		SpringApplication.run(App.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(App.class);
	}
}
