package ru.dstu.lab12.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import java.util.concurrent.TimeUnit;


@Configuration
@EnableWebMvc
//@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        int cacheMaxAge = 5 * 60;
        registry
                .addResourceHandler("/**")
                .addResourceLocations("classpath:/static/")
                .setCacheControl(CacheControl.maxAge(cacheMaxAge, TimeUnit.SECONDS)
                        .mustRevalidate());
        super.addResourceHandlers(registry);
    }
}