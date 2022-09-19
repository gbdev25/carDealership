package driver;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import daos.OfferDAO;
import daos.OfferPostgres;
import daos.ProductDAO;
import daos.ProductPostgres;
import daos.UserDAO;
import daos.UserInventoryDAO;
import daos.UserInventoryPostgres;
import daos.UserPostgres;
import exceptions.LoginException;
import models.Offer;
import models.Product;
import models.User;
import models.userInventory;
import services.AuthService;
import services.ProductService;
import services.UserService;


public class TESTDRIVER {
	static Scanner scan;
	static AuthService as;
	static UserService us;
	static ProductService ps;
	static UserDAO ud = new UserPostgres();
	static ProductDAO pd = new ProductPostgres();
	static OfferDAO od = new OfferPostgres();
	static UserInventoryDAO uid = new UserInventoryPostgres();
	static User u;
	private static Logger log = LogManager.getLogger(Driver.class);
	
	public static void main(String[] args) {
		
		scan = new Scanner(System.in);
		as = new AuthService();
		us = new UserService();
		ps = new ProductService();
		u = new User();
	
		
		 boolean x = true;	
		while (x) {
			switch (menu1()) {
		case "1":
			makeAccount();
			while (x) {
				switch (customerMenu()) {
				case "1":
					makeOffer();
					scan.nextLine();
					break;
				case "2":
					System.out.println(uid.getUserInventoryByUsername(u.getUsername()));
					scan.nextLine();
					break;
				case "3":
					x = false;
					break;
				default:
					System.out.println("Invalid choice, please try again");
					break;
					}
				}
			x = true;
			break;
		
		case "2":
		String loginEntry = login();
			if (loginEntry.equals("employee")) {	
			while (x) {
			switch (employeeMenu()) {
			case "1":
				addProduct();
				break;
			case "2":
				System.out.println(removeProduct());
				scan.nextLine();
				break;
			case "3":
				System.out.println(pendingOffers());
				scan.nextLine();
				break;
			case "4":
				System.out.println(uid.remainingPaymentsList());
				scan.nextLine();
				break;
			case "5":
				x = false;
				break;
			default:
				System.out.println("Invalid choice, please try again");
				break;
			}
			}
			
		}else if(ud.retrieveUserByUsername(loginEntry) != null) {
			while (x) {
			switch (customerMenu()) {
			case "1":
				makeOffer();
				scan.nextLine();
				break;
			case "2":
				System.out.println(uid.getUserInventoryByUsername(u.getUsername()));
				scan.nextLine();
				break;
			case "3":
				x = false;
				break;
			default:
				System.out.println("Invalid choice, please try again");
				break;
			}
			}
		}
		
		x = true;
		break;
		case "3":
			System.out.println("Goodbye");
			System.exit(0);
			break;
		default:
			System.out.println("Invalid choice, please try again");
			break;
	
		}
		}
	}

		


		
	
	
	//reorganize methods
	
	public static String menu1() {
		
		System.out.println("Welcome to Lux Auto");
		System.out.println("What would you like to do?");
		System.out.println("1. Create Account");
		System.out.println("2. Sign in");
		System.out.println("3. Exit");
		String menu1 = scan.nextLine();
		return menu1;
	}
	public static void printProducts() {
		List<Product> products = ps.getProducts();
		for(Product p: products) {
			System.out.println(p);
			
		}
		
		
	}
	public static String customerMenu() {
		System.out.println("What would you like to do?");
		System.out.println("1. View show room floor");
		System.out.println("2. View Owned items");
		System.out.println("3. Back to Main Menu");
		String customerMenu = scan.nextLine();
		return customerMenu;
		
		
	}
	public static String employeeMenu() {
		System.out.println("What would you like to do?");
		System.out.println("1. Add a product");
		System.out.println("2. Remove a product");
		System.out.println("3. View pending offers");
		System.out.println("4. View customer payments ");
		System.out.println("5. Back to Main Menu");
		String employeeMenu = scan.nextLine();
		return employeeMenu;
		
	}
	public static Product addProduct() {
		System.out.println("Enter new product name:");
		String newProductName = scan.nextLine();
		System.out.println("Enter product description");
		String newProductDescription = scan.nextLine();
		Product createNewProduct = new Product();
		createNewProduct.setProduct_name(newProductName);
		createNewProduct.setProduct_description(newProductDescription);
		log.info(ps.createProduct(createNewProduct));
		
		return createNewProduct;
	}
	public static String removeProduct() {
		printProducts();
		System.out.println("Which product would you like to remove");
		int removeItem = scan.nextInt();
		log.info(pd.deleteProductById(removeItem));
		String itemRemoved = "Product " + removeItem +" has been removed";
		
		return itemRemoved;
	}
	public static String pendingOffers() {
		System.out.println(od.retrievePendingOffers());
		System.out.println("Is the the offer going to be accepted or rejected?");
		String rejectAccept = scan.nextLine();
		System.out.println("Select the offer id you would like to decision");
		int pendingOfferId = scan.nextInt();
		Offer offerdescision = new Offer();
		offerdescision.setOfferStatus(rejectAccept);
		offerdescision.setOfferId(pendingOfferId);
		od.desicionOffer(offerdescision);
		String offerFeedback = "Offer " + pendingOfferId + " has been desicioned as " + rejectAccept;
		return offerFeedback;
		
	}
	public static String makeAccount() {
		System.out.println("Create, username: ");
		String newUsername = scan.nextLine();
		System.out.println("Create, password");
		String newPassword = scan.nextLine();
		User createNewUser = new User();
		createNewUser.setUsername(newUsername);
		createNewUser.setPassword(newPassword);
		us.createUser(createNewUser);
		System.out.println("Your account has been created");
		scan.nextLine();
		as.login(newUsername, newPassword);
		u.setUsername(newUsername);
		return newUsername;
		
	}
	public static String makeOffer() {
		printProducts();
		System.out.println("Which product would you like to make an offer on?");
		int itemInterest = scan.nextInt();
		pd.retrieveProductById(itemInterest);
		System.out.println("Enter Offer:");
		int itemOffer = scan.nextInt();
		Offer newOffer = new Offer();
		newOffer.setProductId(itemInterest);
		newOffer.setOfferAmount(itemOffer);
		newOffer.setUsername(u.getUsername());
		log.info(od.createOffer(newOffer));
		String newOfferMessage = newOffer + " has been placed";
		return newOfferMessage;
		
	}
	public static String login() {
		System.out.println("Enter your username: ");
		String username = scan.nextLine();
		System.out.println("Enter your password: ");
		String password = scan.nextLine();
		as.login(username, password);
		u.setUsername(username);
		
		return username;
		
	}
	
}

