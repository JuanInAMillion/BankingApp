package com.bank.main;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.bank.menu.MenuOptions;
import com.bank.model.Customer;
import com.bank.model.Employee;


public class MainBank {
	
private static Logger log=Logger.getLogger("consoleLog.MainBank");
	
	public static void main(String[] args) {
		MenuOptions menuoptions = new MenuOptions();
		Customer customer = null;
		Employee employee = null;
		Scanner sc = new Scanner(System.in);
		
		log.info("Welcome to Chase Bank");
		log.info("-----------------------");
		int ch = 0;
		do {
			log.info("\nChoose an Options");
			log.info("=======================");
			log.info("1)Login");
			log.info("2)Register");
			log.info("3)Employee Login");
			log.info("4)EXIT");
			log.info("");
			try {
				ch=Integer.parseInt(sc.nextLine());
			} catch(NumberFormatException e) {}
			
			switch(ch) {
			case 1:
				menuoptions.customerLogin(sc,customer);
				break;
			case 2:
				menuoptions.customerSignUp(sc,customer);
				break;
			case 3:
				menuoptions.employeeLogin(sc, employee);
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
