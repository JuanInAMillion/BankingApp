package com.app.dao;

import java.util.List;

import com.app.bank.Customer;
import com.app.exception.BusinessException;

public interface CustomerSearchDAO {
	public Customer getCustomerById(int customer_id) throws BusinessException;
	public List<Customer> getAllCustomers() throws BusinessException;
}
