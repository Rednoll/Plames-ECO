package enterprises.inwaiders.plames.eco.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
//@Import(value= {SpringSecurityConfig.class})
public class SpringMvcConfig implements WebMvcConfigurer {
    
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	
    	registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/static/");
    	registry.addResourceHandler("/data/**").addResourceLocations("file:data/");
    }
}
