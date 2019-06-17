package com.santander.autosavings.middleware.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
	@Id
	private String id;
	private String userName;
	private String agencyString;
	private String password;
	private String account;

	
	public User(String id, String userName, String agencyString, String password, String account) {
		super();
		this.id = id;
		this.userName = userName;
		this.agencyString = agencyString;
		this.password = password;
		this.account = account;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAgencyString() {
		return agencyString;
	}
	public void setAgencyString(String agencyString) {
		this.agencyString = agencyString;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	

}
