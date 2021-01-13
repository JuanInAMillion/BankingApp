package com.bank.service;

import com.bank.exception.BusinessException;

public interface MenuService {
	public double withdrawAmount(int account_id, double newBalance) throws BusinessException;
	public double depositAmount(int account_id, double newBalance) throws BusinessException;
	public double searchBalance(int account_id) throws BusinessException;
}
