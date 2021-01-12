package com.bank.dao;

import com.bank.exception.BusinessException;
import com.bank.model.Account;

public interface AccountDAO {
		public int createAccount(Account account) throws BusinessException;
		public int withdrawFromAccount(int account_id, double newBalance) throws BusinessException;
		public int depositToAccount(int account_id, double newBalance) throws BusinessException;
		public Account checkBalance(int account_id) throws BusinessException;	
}
