package com.NaSSIB.spring.SpringMongo.config;

import java.time.Duration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

// rest template builder
@Configuration
public class AppConfig {
  @Bean
  public RestTemplate restTemplate(RestTemplateBuilder builder) {

    return builder.setConnectTimeout(Duration.ofMillis(1000))
        .setReadTimeout(Duration.ofMillis(1000)).build();
  }
}
