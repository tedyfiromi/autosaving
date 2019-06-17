package com.santander.autosavings.middleware.model;

public class OperationVO {
	
	public String account;
	public String idGoal;
	public double value;
	
	
	public OperationVO(String account, String idGoal, double addValue) {
		super();
		this.account = account;
		this.idGoal = idGoal;
		this.value = addValue;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getIdGoal() {
		return idGoal;
	}
	public void setIdGoal(String idGoal) {
		this.idGoal = idGoal;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double addValue) {
		this.value = addValue;
	}	

}
