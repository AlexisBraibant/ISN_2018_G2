package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class testHeros {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("début du test");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("fin du test");
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testM() {
		fail("Not yet implemented");
	}

}
