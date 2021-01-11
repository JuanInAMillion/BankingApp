package com.bank.dao;

import com.bank.exception.BusinessException;
import com.bank.model.Customer;

public interface CustomerDAO {
		public Customer verifyLogin(String email, String password) throws BusinessException;
		public int createCustomer(Customer customer) throws BusinessException;
}
