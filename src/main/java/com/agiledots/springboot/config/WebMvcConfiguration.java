package com.agiledots.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebMvcConfiguration implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/files/**")
				// .addResourceLocations("classpath:/images/") // OK
				// .addResourceLocations("file:///E:/10.Photos/GooglePhotos/PS/") OK
				.addResourceLocations("file:///E:/10.Photos/GooglePhotos/PS/", "classpath:/images/")
				.setCachePeriod(31556926);
	}

}
