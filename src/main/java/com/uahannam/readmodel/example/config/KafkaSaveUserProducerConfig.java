package com.uahannam.readmodel.example.config;

import com.uahannam.readmodel.example.dto.SaveUserKafkaDto;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.Map;

@EnableKafka
@Configuration
@RequiredArgsConstructor
public class KafkaSaveUserProducerConfig {

    private final Environment environment;


    @Bean(name = "saveUserDataProducerFactory")
    DefaultKafkaProducerFactory<String, SaveUserKafkaDto> saveUserDataProducerFactory() {
        return new DefaultKafkaProducerFactory<>(saveUserDataProducerConfig());
    }

    @Bean(name = "saveUserDataProducerConfig")
    Map<String, Object> saveUserDataProducerConfig() {
        return Map.of(
                ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, environment.getProperty("spring.kafka.producer.bootstrap-servers"),
                ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class,
                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class
        );
    }

    @Bean(name = "saveUserKafkaTemplate")
    KafkaTemplate<String, SaveUserKafkaDto> saveUserKafkaTemplate() {
        return new KafkaTemplate<>(saveUserDataProducerFactory());
    }
}
