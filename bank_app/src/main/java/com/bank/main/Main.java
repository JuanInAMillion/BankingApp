package com.bank.main;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.dao.CustomerCrudDAO;
import com.app.dao.CustomerSearchDAO;
import com.bank.dao.impl.CustomerCrudDAOImpl;
import com.bank.dao.impl.CustomerSearchDAOImpl;
import com.bank.exception.BusinessException;
import com.bank.model.Customer;

public class Main {
	
	private static Logger log=Logger.getLogger(Main.class);
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		log.info("Welcome to Chase Bank");
		log.info("-----------------------");
		int ch = 0;
		
		do {
			log.info("Customer Options");
			log.info("=======================");
			log.info("1)Login");
			log.info("2)Sign Up");
			log.info("3)EXIT");
			try {
				ch=Integer.parseInt(sc.nextLine());
			} catch(NumberFormatException e) {}
			
			switch(ch) {
			case 1:
				log.info("\nChoice 1\n");
				break;
			case 2:
				log.info("\nChoice 2\n");
				break;
			case 3:
				log.info("\nGoodbye, have a nice day!\n");
				break;
			default:
				log.info("\nInvalid Menu Option... Kindly Retry\n");
				break;
			}
		} while(ch != 3);
		
		
		
	//	CustomerCrudDAO cruddao = new CustomerCrudDAOImpl();
	//	CustomerSearchDAO searchdao = new CustomerSearchDAOImpl();
		
		
/*
		Customer c = new Customer(4, "Fabidaly", "Valera", "12/4/2006", "F", "111-11-1111", "111 111 111", "342423333", "Fabidaly@gmail.com");
		try {
			if(cruddao.createCustomer(c)!=0) {
				log.info("\nCreated Successfully");
			}
		} catch(BusinessException e) {
			log.error(e.getMessage());
		}
*/
/*		
		try {
			Customer customer=searchdao.getCustomerById(1);
			if(customer!=null) {
				log.info("\nDetails of customer with id of " + customer.getCustomer_id());
				log.info(customer);
			}
		} catch (BusinessException e) {
			log.error(e.getMessage());
		};
*/

		
	}
}
