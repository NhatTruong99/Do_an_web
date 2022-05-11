package qlshopquanao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import nz.net.ultraq.thymeleaf.LayoutDialect;

@Controller
@SpringBootApplication
public class QuanLyShopQuanAoApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuanLyShopQuanAoApplication.class, args);
	}
	
	/* Để thêm Layout Admin */
	 @Bean
	  public LayoutDialect layoutDialect() {
	    return new LayoutDialect();
	 }
	 
	 
}
