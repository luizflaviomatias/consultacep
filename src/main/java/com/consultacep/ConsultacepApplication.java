package com.consultacep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ConsultacepApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsultacepApplication.class, args);
	}

   @Bean
   public RestTemplate getRestTemplate() {
      return new RestTemplate();
   }
	
}
