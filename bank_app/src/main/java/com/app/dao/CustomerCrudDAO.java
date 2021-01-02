package com.app.dao;

import java.util.List;

import com.app.bank.Customer;
import com.app.exception.BusinessException;

public interface CustomerCrudDAO {
	public int createCustomer(Customer customer) throws BusinessException;
	public Customer getCustomerByID(int customer_id);
	public List<Customer> getAllCustomers();
}
