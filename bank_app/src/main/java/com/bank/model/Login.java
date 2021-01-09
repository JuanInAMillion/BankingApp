package com.bank.model;

public class Login {
	private int customer_id;
	private String username;
	private String password;
	
	public Login() {
		// TODO Auto-generated constructor stub
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Login [customer_id=" + customer_id + ", username=" + username + ", password=" + password + "]";
	}
	
	
}
