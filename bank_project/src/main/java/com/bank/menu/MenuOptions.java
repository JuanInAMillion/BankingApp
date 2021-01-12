package com.bank.menu;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.bank.dao.CustomerDAO;
import com.bank.dao.EmployeeDAO;
import com.bank.dao.impl.CustomerDAOImpl;
import com.bank.dao.impl.EmployeeDAOImpl;
import com.bank.exception.BusinessException;
import com.bank.model.Customer;
import com.bank.model.Employee;

public class MenuOptions {
	private static Logger log=Logger.getLogger("consoleLog.Main");
	
	//Customer Login
	public void customerLogin(Scanner sc, Customer customer) {
		String customeremail ="";
		String customerpassword = "";
		
		CustomerDAO login = new CustomerDAOImpl();
		
		log.info("Enter Your Email: ");
		customeremail = sc.nextLine();
		log.info("Enter Your Password: ");
		customerpassword = sc.nextLine();
		
		try {
			Customer c = login.customerVerifyLogin(customeremail, customerpassword);
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
			log.info("\nCustomer Options");
			log.info("=======================");
			log.info("1)Withdraw");
			log.info("2)Deposit");
			log.info("3)Check Balance");
			log.info("4)EXIT");
			log.info("");
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
	
	//Customer Registration
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
		
		Customer c = new Customer(first_name, last_name,  gender, address, phone, email, password);	
		try {
			if(register.createCustomer(c)!=0) {
				log.info("Registration Successful. Please wait until your are approved before you Login\n\n");
			}
		} catch(BusinessException e) {
			log.error(e.getMessage());
		}
		
	}

	
	//Employee Sign in
	public void employeeLogin(Scanner sc, Employee employee) {
		String employeeemail ="";
		String employeepassword = "";
		
		EmployeeDAO login = new EmployeeDAOImpl();
		
		log.info("Enter Your Employee Email: ");
		employeeemail = sc.nextLine();
		log.info("Enter Your Password: ");
		employeepassword = sc.nextLine();
		
		try {
			Employee em = login.employeeVerifyLogin(employeeemail, employeepassword);
			employeeMenu();
			if (em!=null) {
				log.info("");
			}
		} catch (BusinessException e) {
			log.error(e.getMessage());
		}
	}
	
	//Employee menu after Login
	public static void employeeMenu() {
		EmployeeDAO dao = new EmployeeDAOImpl();
		Scanner sc = new Scanner(System.in);
		int ch = 0;
		do {
			log.info("\nHello Chase Employee");
			log.info("=======================");
			log.info("1)View All Customers");
			log.info("2)Locate Customer By Email");
			log.info("3)EXIT\n");
			try {
				ch=Integer.parseInt(sc.nextLine());
			} catch(NumberFormatException e) {}
			
			switch(ch) {
			case 1:
		  		// get all customers from the list	
				try {
					List<Customer> customerList = dao.getAllCustomers();
					if(customerList!=null && customerList.size()!=0) {
						log.info("\n\nFound " + customerList.size() + " no of customer in DB.... Printing them all");
						for(Customer c: customerList) {
							log.info(c);
						}
					}
				} catch (BusinessException e) {
					log.error(e.getMessage());
				}
		
				break;
			case 2:
				//search by email
				String email = "";
				
				log.info("Enter The Customer Email You Are Searching: ");
				email = sc.nextLine();
				try {
					Customer customerByEmail = dao.getCustomerByEmail(email);
					log.info("\nCustomer with the email "+email +" was found.");
					log.info("\n"+ customerByEmail.toString());
					if (customerByEmail!=null) {
						log.info("");
					}
				} catch (BusinessException e) {
					log.error(e.getMessage());
				}

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

	
	
}
