package com.music.gaana.config;

/**
 *  create a configuration class 
 * AppConfig to create a RestTemplate bean.
 */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate(new SimpleClientHttpRequestFactory());
    }
}