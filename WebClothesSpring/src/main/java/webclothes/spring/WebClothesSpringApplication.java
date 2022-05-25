package webclothes.spring;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import nz.net.ultraq.thymeleaf.LayoutDialect;

@Controller
@Configuration
@SpringBootApplication
public class WebClothesSpringApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(WebClothesSpringApplication.class, args);
	}
	
	/* Để thêm Layout Admin */
	 @Bean
	  public LayoutDialect layoutDialect() {
	    return new LayoutDialect();
	 }
	 
	/* Để Upload ảnh vào folder static/images */
	 @Override
	 public void addResourceHandlers(ResourceHandlerRegistry registry) {
		 exposeDirectory("src/main/resources/static/images", registry);
	 }
	     
	    private void exposeDirectory(String dirName, ResourceHandlerRegistry registry) {
	        Path uploadDir = Paths.get(dirName);
	        String uploadPath = uploadDir.toFile().getAbsolutePath();
	         
	        if (dirName.startsWith("../")) dirName = dirName.replace("../", "");
	         
	        registry.addResourceHandler("/" + dirName + "/**").addResourceLocations("file:/"+ uploadPath + "/");
	    }
}
