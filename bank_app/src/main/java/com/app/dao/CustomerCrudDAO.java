package com.app.dao;

import java.util.List;

import com.bank.exception.BusinessException;
import com.bank.model.Customer;

public interface CustomerCrudDAO {
	public int createCustomer(Customer customer) throws BusinessException;
}
