package com.EIS.Receipt_Generator.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class config {
	@Bean
    public RestTemplate restTesmplate() {
        return new RestTemplate();
    }
}
