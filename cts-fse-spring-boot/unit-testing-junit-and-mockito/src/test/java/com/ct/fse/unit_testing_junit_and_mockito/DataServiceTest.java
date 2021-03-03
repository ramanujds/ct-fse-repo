package com.ct.fse.unit_testing_junit_and_mockito;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
@TestInstance(Lifecycle.PER_CLASS)
class DataServiceTest {

	@BeforeAll
	public void beforeTestStrat() {
		System.out.println("Testing Started . ");
	}
	
	@BeforeEach
	void initEachTest() {
		System.out.println("Test Started..");
	}
	
	@AfterEach
	void afterEachTest() {
		System.out.println("Test Completed..");
	}
	
	
	@Test
	void testGetRepo() {
		fail("Not yet implemented");
	}

	@Test
	void testSetRepo() {
		fail("Not yet implemented");
	}

	@Test
	void testAdd() {
		fail("Not yet implemented");
	}

	@Test
	void testDivide() {
		fail("Not yet implemented");
	}

	@Test
	void testAddData() {
		fail("Not yet implemented");
	}

}
