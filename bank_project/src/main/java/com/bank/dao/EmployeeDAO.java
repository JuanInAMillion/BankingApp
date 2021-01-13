package com.bank.dao;

import java.util.List;

import com.bank.model.Account;
import com.bank.model.Customer;
import com.bank.exception.BusinessException;
import com.bank.model.Employee;

public interface EmployeeDAO {
	public Employee employeeVerifyLogin(String email, String password) throws BusinessException;
	public List<Customer> getAllCustomers() throws BusinessException;
	public List<Account> getAllBankAccounts() throws BusinessException;
	public Customer getCustomerByEmail(String email) throws BusinessException;
	public int registerCustomer(int account_id, String statusChange) throws BusinessException;
}
