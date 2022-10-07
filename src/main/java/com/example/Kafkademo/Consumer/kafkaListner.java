package com.example.Kafkademo.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.Kafkademo.dao.AccountDao;
import com.example.Kafkademo.entities.account;
@Service

public class kafkaListner {
	
	@Autowired
	private AccountDao accountDao;

    @KafkaListener(topics = "acc", containerFactory = "kafkaListenerContainerFactory", groupId = "group1")
    public void listen(account value){
        System.out.println("Message Received :: "+value.toString());
        accountDao.save(value);

    }


}
