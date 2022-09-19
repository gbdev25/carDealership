package project0;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import models.User;
import services.AuthService;

public class AuthServiceTests {

	private static AuthService as;
	@BeforeAll
	public static void setUp() {
	as = new AuthService();
	}
	
	@AfterAll
	public static void tearDown() {
		System.out.println("End of Test");
	}
	
	@BeforeEach
	public void before() {
		System.out.println("@Before each behavior");
	}
	@AfterEach
	public void afterEach() {
		System.out.println("@After each behavior");
	}
	
	@Test
	public void loginCustomer() {
		User u = new User();
		u.setUsername("username");
		u.setPassword("password");
		u.setId(2);
		u.setAuth(false);
		User shouldBe = as.login("username","password");
		assertEquals(u, shouldBe);
	}
	
	@Test
	public void loginNonCustomer() {
		User u = new User();
		u.setUsername("Jane");
		u.setPassword("Doe");
		u.setId(30);
		u.setAuth(false);
		User shouldBe = as.login("Jane","Doe");
		assertEquals(u, shouldBe);
	}
	

}
