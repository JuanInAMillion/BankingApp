package com.app.bank;

public class Customer {
	private int customer_id;
	private String first_name;
	private String last_name;
	private String dob;
	private String gender;
	private String ssn;
	private String state_id;
	private String phone;
	private String email;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(int customer_id, String first_name, String last_name, String dob, String gender, String ssn,
			String state_id, String phone, String email) {
		super();
		this.customer_id = customer_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.dob = dob;
		this.gender = gender;
		this.ssn = ssn;
		this.state_id = state_id;
		this.phone = phone;
		this.email = email;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	
	public String getState_id() {
		return state_id;
	}

	public void setState_id(String state_id) {
		this.state_id = state_id;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", dob=" + dob + ", gender=" + gender + ", ssn=" + ssn + ", state_id=" + state_id + ", phone=" + phone
				+ ", email=" + email + "]";
	}

	
	

	
}
