package com.bank.dao;

import com.bank.exception.BusinessException;
import com.bank.model.Account;

public interface AccountDAO {
		public int createAccount(Account account) throws BusinessException;
		public double searchBalance(int account_id) throws BusinessException;	
}
