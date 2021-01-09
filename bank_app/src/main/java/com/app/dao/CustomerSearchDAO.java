package com.app.dao;

import com.bank.exception.BusinessException;
import com.bank.model.Customer;

public interface CustomerSearchDAO {
	public Customer getCustomerById(int customer_id) throws BusinessException;
}
