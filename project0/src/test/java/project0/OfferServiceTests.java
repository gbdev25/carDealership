package project0;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class OfferServiceTests {

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
