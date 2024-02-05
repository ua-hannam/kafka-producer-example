package com.uahannam.readmodel.example.config;

import com.uahannam.readmodel.example.common.EventProducer;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationEventConfig {

    @Bean
    InitializingBean initializingBean(ApplicationContext applicationContext) {
        return () -> EventProducer.setEventPublisher(applicationContext);
    }
}
