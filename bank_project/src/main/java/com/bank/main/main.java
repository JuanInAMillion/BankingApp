package com.bank.main;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.bank.menu.MenuHolder;
import com.bank.model.Customer;
import com.bank.model.Employee;


public class main {
	
private static Logger log=Logger.getLogger("consoleLog.Main");
	
	public static void main(String[] args) {
		MenuHolder mh = new MenuHolder();
		Customer customer = null;
		Employee employee = null;
		
		Scanner sc = new Scanner(System.in);
		
		log.info("Welcome to Chase Bank");
		log.info("-----------------------");
		
		int ch = 0;
		do {
			log.info("");
			log.info("Choose an Options");
			log.info("=======================");
			log.info("1)Login");
			log.info("2)Sign Up");
			log.info("3)Employee Login");
			log.info("4)EXIT");
			log.info("");
			try {
				ch=Integer.parseInt(sc.nextLine());
			} catch(NumberFormatException e) {}
			
			switch(ch) {
			case 1:
				mh.customerLogin(sc,customer);
				break;
			case 2:
				mh.customerSignUp(sc,customer);
				break;
			case 3:
				mh.employeeLogin(sc, employee);
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

}
