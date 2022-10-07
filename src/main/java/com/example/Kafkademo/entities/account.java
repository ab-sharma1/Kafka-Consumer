package com.example.Kafkademo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "accounts")
public class account {
	private int accountId;
	private int bankId;
	private String accountType;
	private float balance;
	private String country;
	private String accountCreatedDate;
	
	@Id
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public int getBankId() {
		return bankId;
	}
	public void setBankId(int bankId) {
		this.bankId = bankId;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAccountCreatedDate() {
		return accountCreatedDate;
	}
	public void setAccountCreatedDate(String accountCreatedDate) {
		this.accountCreatedDate = accountCreatedDate;
	}

	@Override
	public String toString() {
		return "account [accountId=" + accountId + ", bankId=" + bankId + ", accountType=" + accountType + ", balance="
				+ balance + ", country=" + country + ", accountCreatedDate=" + accountCreatedDate + "]";
	}

}
