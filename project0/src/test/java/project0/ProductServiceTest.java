package project0;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import models.User;

import services.ProductService;

public class ProductServiceTest {

	private static ProductService ps;
	@BeforeAll
	public static void setUp() {
	ps = new ProductService();
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

	
}
