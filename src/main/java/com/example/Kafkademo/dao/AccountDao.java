package com.example.Kafkademo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Kafkademo.entities.account;
@Repository
public interface AccountDao extends JpaRepository<account, Integer>{
	
	

}
