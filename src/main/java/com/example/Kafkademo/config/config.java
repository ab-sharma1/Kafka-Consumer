package com.example.Kafkademo.config;

import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.example.Kafkademo.entities.account;



@Configuration

public class config {
	
	
	


	

	    @Bean
	    public ConsumerFactory<String,account> consumerFactory(KafkaProperties kafkaProperties){
	        return new DefaultKafkaConsumerFactory<>(kafkaProperties.buildConsumerProperties(),new StringDeserializer(),new JsonDeserializer<>(account.class));
	    }

	    @Bean
	    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String,account>> kafkaListenerContainerFactory(KafkaProperties kafkaProperties){
	        ConcurrentKafkaListenerContainerFactory<String,account> factory=new ConcurrentKafkaListenerContainerFactory<>();
	        factory.setConsumerFactory(consumerFactory(kafkaProperties));
	        return factory;
	    }

	}
	
	


