package com.agiledots.springboot.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * 
 * @author ZHONG
 * 
 * 开启 @EnableWebMvc 禁用默认的static下的静态设置
 */

@Configuration
@EnableWebMvc
public class WebMvcConfiguration implements WebMvcConfigurer {

    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
            "classpath:/META-INF/resources/", "classpath:/resources/",
            "classpath:/static/", "classpath:/public/" };

	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/files/**")
				// .addResourceLocations("classpath:/images/") // OK
				// .addResourceLocations("file:///E:/10.Photos/GooglePhotos/PS/") OK
				.addResourceLocations("file:///E:/10.Photos/GooglePhotos/PS/", "classpath:/images/")
				.setCachePeriod(31556926);
		
		// 恢复禁用的static的设置
        registry.addResourceHandler("/**")
        .addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
	}

}
