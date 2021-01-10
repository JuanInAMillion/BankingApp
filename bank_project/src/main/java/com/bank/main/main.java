package com.bank.main;

import java.util.Scanner;


public class main {
	
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
		

	}

}
