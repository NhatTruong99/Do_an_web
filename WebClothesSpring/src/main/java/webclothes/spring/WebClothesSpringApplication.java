package webclothes.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;

import nz.net.ultraq.thymeleaf.LayoutDialect;

@Controller
@SpringBootApplication
public class WebClothesSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebClothesSpringApplication.class, args);
	}
	
	/* Để thêm Layout Admin */
	 @Bean
	  public LayoutDialect layoutDialect() {
	    return new LayoutDialect();
	 }
	 
	 
}
