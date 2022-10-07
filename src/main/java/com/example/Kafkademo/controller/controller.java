package com.example.Kafkademo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Kafkademo.dao.AccountDao;
import com.example.Kafkademo.entities.account;



@RestController
@RequestMapping("/api")
public class controller {
	
	@Autowired
	AccountDao accountDao;
	
	@GetMapping("/userAccounts")
	public List<account> get(){
		return accountDao.findAll();
	}
	
	@PostMapping("/userAccounts")
	public account save(@RequestBody account Obj) {
		return accountDao.save(Obj);
	}
	
	@GetMapping("/userAccounts/{id}")
	public account get(@PathVariable int id) {
		Optional<account> userAccount = accountDao.findById(id);
		if(userAccount.isPresent()) {
			return userAccount.get();
		}else {
			throw new RuntimeException("userAccount not found for the id "+id);
		}
	}
	
	@DeleteMapping("/userAccounts/{id}")
	public String delete(@PathVariable int id) {
		Optional<account> userAccount = accountDao.findById(id);
		if(userAccount.isPresent()) {
			accountDao.delete(userAccount.get());
			return "userAccount is deleted with id "+id;
		}else {
			throw new RuntimeException("Account not found for the id "+id);
		}
	}
	
	@PutMapping("/userAccounts")
	public account update(@RequestBody account Obj) {
		return accountDao.save(Obj);
	}
	

	
	
}