package com.app.main;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import com.app.bank.Customer;
import com.app.dao.CustomerCrudDAO;
import com.app.dao.impl.CustomerCrudDAOImpl;
import com.app.exception.BusinessException;

public class Main {
	
	private static Logger log=Logger.getLogger(Main.class);
	
	public static void main(String[] args) {
		log.info("Hello");
		
		CustomerCrudDAO dao = new CustomerCrudDAOImpl();
		

		Customer c = new Customer(4, "Fabidaly", "Valera", "12/4/2006", "F", "111-11-1111", "111 111 111", "313 Gates Place", "1E", "Bronx", "NY", "86753", "Fabidaly@gmail.com", "342423333");

		try {
			if(dao.createCustomer(c)!=0) {
				log.info("Created Successfully");
			}
		} catch(BusinessException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
