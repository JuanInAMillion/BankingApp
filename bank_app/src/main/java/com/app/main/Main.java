package com.app.main;

import java.util.List;

import org.apache.log4j.Logger;

import com.app.bank.Customer;
import com.app.dao.CustomerCrudDAO;
import com.app.dao.impl.CustomerCrudDAOImpl;
import com.app.exception.BusinessException;

public class Main {
	
	private static Logger log=Logger.getLogger(Main.class);
	
	public static void main(String[] args) {
		
		CustomerCrudDAO dao = new CustomerCrudDAOImpl();
		
/*
		Customer c = new Customer(4, "Fabidaly", "Valera", "12/4/2006", "F", "111-11-1111", "111 111 111", "313 Gates Place", "1E", "Bronx", "NY", "86753", "Fabidaly@gmail.com", "342423333");
		try {
			if(dao.createCustomer(c)!=0) {
				log.info("\nCreated Successfully");
			}
		} catch(BusinessException e) {
			log.error(e.getMessage());
		}
*/
/*		
		try {
			Customer customer=dao.getCustomerById(1);
			if(customer!=null) {
				log.info("\nDetails of customer with id of " + customer.getCustomer_id());
				log.info(customer);
			}
		} catch (BusinessException e) {
			log.error(e.getMessage());
		};
*/
		try {
			List<Customer> customerList=dao.getAllCustomers();
			if(customerList!=null && customerList.size()!=0) {
				log.info("\nFound " +customerList.size()+ " customers in the DB...");
				for(Customer c:customerList) {
					log.info(c);
				}
			}
		} catch (BusinessException e) {
			log.error(e.getMessage());
		}
		
		
	}
}
