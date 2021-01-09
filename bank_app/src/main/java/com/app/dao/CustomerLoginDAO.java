package com.app.dao;

import com.bank.exception.BusinessException;
import com.bank.model.Login;

public interface CustomerLoginDAO {
	public int validLogin(String username, String password) throws BusinessException;
	public int createLogin(Login login) throws BusinessException;	
}
