package com.bank.main;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.bank.dao.CustomerDAO;
import com.bank.dao.impl.CustomerDAOImpl;
import com.bank.exception.BusinessException;
import com.bank.model.Customer;


public class main {
	
private static Logger log=Logger.getLogger("consoleLog.Main");
	
	public static void main(String[] args) {
		
		Customer customer = null;
		
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
				customerLogin(sc,customer);
				break;
			case 2:
				customerSignUp(sc,customer);
				break;
			case 3:
				log.info("\nThank You For Visiting Chase Bank, have a nice day!\n");
				break;
			default:
				log.info("\nInvalid Menu Option. Choose from the given Options.\n");
				break;
			}
		} while(ch != 3);
		
	}
	
	private static void customerLogin(Scanner sc, Customer customer) {
		String email ="";
		String password = "";
		
		CustomerDAO login = new CustomerDAOImpl();
		
		log.info("Enter Your Email: ");
		email = sc.nextLine();
		log.info("Enter Your Password: ");
		password = sc.nextLine();
		
		try {
			Customer c = login.verifyLogin(email, password);
			log.info(c.toString());
			if (c!=null) {
				log.info("");
			}
		} catch (BusinessException e) {
			log.error(e.getMessage());
		}
	}
	
	private static void customerSignUp(Scanner sc, Customer customer) {
		String first_name, last_name, dob, gender,address,email,password ;
		long ssn,phone;
		
		CustomerDAO register = new CustomerDAOImpl();
			
		log.info("Enter Your First Name: ");
		first_name = sc.nextLine();
		log.info("Enter Your Last Name: ");
		last_name = sc.nextLine();
		log.info("Enter Your Dob yyyy-mm-dd: ");
		dob = sc.nextLine();
		log.info("Enter Your gender: M or F");
		gender = sc.nextLine();
		log.info("Enter Your SSN# 111223333: ");
		ssn = Long.parseLong(sc.nextLine());
		log.info("Enter Your Address: ");
		address = sc.nextLine();
		log.info("Enter Your Phone# 8005551234: ");
		phone = Long.parseLong(sc.nextLine());
		log.info("Enter Your Email: ");
		email = sc.nextLine();
		log.info("Enter Your Password: ");
		password = sc.nextLine();
		
		Customer c = new Customer(4, first_name, last_name, dob, gender, ssn, address, phone, email, password);	
		try {
			if(register.createCustomer(c)!=0) {
				log.info("Registration Successful. Please wait until your are approved before you Login\n\n");
			}
		} catch(BusinessException e) {
			log.error(e.getMessage());
		}
		
	}

}
