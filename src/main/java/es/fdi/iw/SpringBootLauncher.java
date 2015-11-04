package es.fdi.iw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication
public class SpringBootLauncher extends SpringBootServletInitializer {
	
	// Usado cuando lanzamos la aplicación con Spring Boot	
    public static void main(String[] args) throws Exception {
        SpringApplication.run(new Class[] {SpringBootLauncher.class, ContextInitializer.class}, args);
    }
    
    @Bean  
    public InternalResourceViewResolver setupViewResolver() {  
    	InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");  
        resolver.setSuffix(".jsp");  
        return resolver;  
    }
}
