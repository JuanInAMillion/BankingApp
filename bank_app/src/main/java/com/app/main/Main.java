package com.app.main;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.bank.Customer;
import com.app.dao.CustomerCrudDAO;
import com.app.dao.CustomerSearchDAO;
import com.app.dao.impl.CustomerCrudDAOImpl;
import com.app.dao.impl.CustomerSearchDAOImpl;
import com.app.exception.BusinessException;

public class Main {
	
	private static Logger log=Logger.getLogger(Main.class);
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Chase Bank");
		System.out.println("-----------------------");
		int ch = 0;
		
		do {
			System.out.println("Customer Options");
			System.out.println("=======================");
			System.out.println("1)Login");
			System.out.println("2)Sign Up");
			System.out.println("3)EXIT");
			try {
				ch=Integer.parseInt(sc.nextLine());
			} catch(NumberFormatException e) {}
			
			switch(ch) {
			case 1:
				System.out.println("\nChoice 1\n");
				break;
			case 2:
				System.out.println("\nChoice 2\n");
				break;
			case 3:
				System.out.println("\nGoodbye, have a nice day!\n");
				break;
			default:
				System.out.println("\nInvalid Menu Option... Kindly Retry\n");
				break;
			}
		} while(ch != 3);
		
		
		
		CustomerCrudDAO cruddao = new CustomerCrudDAOImpl();
		CustomerSearchDAO searchdao = new CustomerSearchDAOImpl();
		
		
/*
		Customer c = new Customer(4, "Fabidaly", "Valera", "12/4/2006", "F", "111-11-1111", "111 111 111", "313 Gates Place", "1E", "Bronx", "NY", "86753", "Fabidaly@gmail.com", "342423333");
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
			Customer customer=searchdao.getCustomerById(2);
			if(customer!=null) {
				log.info("\nDetails of customer with id of " + customer.getCustomer_id());
				log.info(customer);
			}
		} catch (BusinessException e) {
			log.error(e.getMessage());
		};
*/
/*		
		try {
			List<Customer> customerList=searchdao.getAllCustomers();
			if(customerList!=null && customerList.size()!=0) {
				log.info("\nFound " +customerList.size()+ " customers in the DB...");
				for(Customer c:customerList) {
					log.info(c);
				}
			}
		} catch (BusinessException e) {
			log.error(e.getMessage());
		}
*/		
		
	}
}
