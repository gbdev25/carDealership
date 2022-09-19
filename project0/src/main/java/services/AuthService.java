package services;


import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import daos.ProductPostgres;
import daos.UserDAO;
import daos.UserPostgres;
import driver.Driver;
import exceptions.LoginException;
import models.User;

public class AuthService {
private static Logger log = LogManager.getLogger(AuthService.class);
static Scanner scan = new Scanner(System.in);
static ProductPostgres prodpost = new ProductPostgres();
private UserDAO ud = new UserPostgres();
	

	public User login(String username, String password) throws LoginException {
			if(username == null || password == null) {
				LoginException e = new LoginException();
				log.error("Login exception was thrown" + e.fillInStackTrace());
		}
		
		User u = ud.retrieveUserByUsername(username);
			if(u == null || !u.getPassword().equals(password)) {
			System.out.println("Incorrect Credentials");
			System.out.println("Please try again");
			LoginException e = new LoginException();
			log.error("Login exception was thrown" + e.fillInStackTrace());
			u = null;
			}else {
			
				
			}
			return u;
	}		
	
		
			
		
		

	
	
	public static String employeeMenu() {
		System.out.println("What would you like to do?");
		System.out.println("1. Add or Remove an item");
		System.out.println("2. View pending offers");
		System.out.println("3. View outstanding payments ");
		System.out.println("4. Exit");
		String employeeMenu = scan.nextLine();
		return employeeMenu;
		
	}
	public static String customerMenu() {
		System.out.println("what would you like to do?");
		System.out.println("1. View Show floor");
		System.out.println("2. View Owned items");
		System.out.println("3. Exit");
		String customerMenu = scan.nextLine();
		return customerMenu;
		
	
}

}

