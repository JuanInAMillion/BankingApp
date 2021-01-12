package com.bank.menu;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.bank.dao.CustomerDAO;
import com.bank.dao.impl.CustomerDAOImpl;
import com.bank.exception.BusinessException;
import com.bank.model.Customer;

public class MenuHolder {
	private static Logger log=Logger.getLogger("consoleLog.Main");
	
	//Customer Login
	public void customerLogin(Scanner sc, Customer customer) {
		String email ="";
		String password = "";
		
		CustomerDAO login = new CustomerDAOImpl();
		
		log.info("Enter Your Email: ");
		email = sc.nextLine();
		log.info("Enter Your Password: ");
		password = sc.nextLine();
		
		try {
			Customer c = login.verifyLogin(email, password);
			customerMenu();
			if (c!=null) {
				log.info("");
			}
		} catch (BusinessException e) {
			log.error(e.getMessage());
		}
	}
	
	//customer menu after login
	public static void customerMenu() {
		Scanner sc = new Scanner(System.in);
		int ch = 0;
		do {
			log.info("Customer Options");
			log.info("=======================");
			log.info("1)Withdraw");
			log.info("2)Deposit");
			log.info("3)Check Balance");
			log.info("4)EXIT");
			try {
				ch=Integer.parseInt(sc.nextLine());
			} catch(NumberFormatException e) {}
			
			switch(ch) {
			case 1:
				log.info("\nWithdraw\n");
				break;
			case 2:
				log.info("\nDeposit\n");
				break;
			case 3:
				log.info("\nCheck Balance\n");
				break;
			case 4:
				log.info("\nThank You For Visiting Chase Bank, have a nice day!\n");
				break;
			default:
				log.info("\nInvalid Menu Option. Choose from the given Options.\n");
				break;
			}
		} while(ch != 4);
	}
	
	//Customer Sign Up
	public void customerSignUp(Scanner sc, Customer customer) {
		String first_name, last_name, gender,address,email,password ;
		long phone;
		
		CustomerDAO register = new CustomerDAOImpl();
			
		log.info("Enter Your First Name: ");
		first_name = sc.nextLine();
		log.info("Enter Your Last Name: ");
		last_name = sc.nextLine();
		log.info("Enter Your gender: M or F");
		gender = sc.nextLine();
		log.info("Enter Your Address: ");
		address = sc.nextLine();
		log.info("Enter Your Phone# 8005551234: ");
		phone = Long.parseLong(sc.nextLine());
		log.info("Enter Your Email: ");
		email = sc.nextLine();
		log.info("Enter Your Password: ");
		password = sc.nextLine();
		
		Customer c = new Customer(4, first_name, last_name,  gender, address, phone, email, password);	
		try {
			if(register.createCustomer(c)!=0) {
				log.info("Registration Successful. Please wait until your are approved before you Login\n\n");
			}
		} catch(BusinessException e) {
			log.error(e.getMessage());
		}
		
		
	}
}
