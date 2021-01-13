package com.bank.dao;

import java.util.List;

import com.bank.exception.BusinessException;
import com.bank.model.Transaction;

public interface TransactionDAO {
	public int createTransaction(Transaction transaction) throws BusinessException;
	public List<Transaction> getTransactionById(int customer_id) throws BusinessException;
}
