package com.api.base;

public class BankAccount {
	private String accountNumber;
	private double  balance;
	
	public BankAccount(String accountNumber, double balance) {
		
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	
	public String getAccountNumber(){
		return accountNumber;
	}
	
   public double getBalance() {
	   return balance;
   }
   
   public void deposite(double amount) {
	if (amount > 0) {
		balance += amount;
	}

}
   
   public void withdraw(double amount) {
	 if (amount > 0 && amount <= balance) {
		balance -=amount;
	}
	 
	 
	 

}
	
	
	
	
	

}
