package com.mefunny;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class MeFunnyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeFunnyApplication.class, args);
	}
	
	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                //allows C O R s mapping
            	 registry.addMapping("/**")
            	 .allowedOrigins("*")
                 .allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH")
                 .allowedHeaders("*");

            }
        };
    }

}
