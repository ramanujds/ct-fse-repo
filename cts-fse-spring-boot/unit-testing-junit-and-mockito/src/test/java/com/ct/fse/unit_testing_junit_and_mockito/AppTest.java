package com.ct.fse.unit_testing_junit_and_mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
//@TestInstance(Lifecycle.PER_CLASS)

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class AppTest {

	
	@InjectMocks
	DataService service;
	
	@Spy
	DataRepo mockedRepo;
	
	int x=0;
	
	
	
//	DataRepo repo=new DataRepo() {
//		
//		@Override
//		public String addData() {
//			return "Hello World";
//		}
//	};
	
	@Test
	void testAddData() {
		
		
		when(mockedRepo.addData()).thenReturn("Hello World");
		
		service.setRepo(mockedRepo);
		assertEquals("Hello World",service.addData());
	}
	
	
//	@Test
//	void test_add() {
//		System.out.println("x = "+x);
//		x++;
//		int actual=service.add(10, 20);
//		int expected=30;
//		assertEquals(expected, actual,()->{
//			System.err.println("method test_add() failed.");
//			return "Failed";
//		});
//	}
//	
//	@Test
//	void test_divide() {
//		System.out.println("x = "+x);
//		x++;
//		assertEquals(2, service.divide(10, 2));
//	}
//	
//	@Test
//	void test_divide_with_exception() {
//		System.out.println("x = "+x);
//		x++;
//		assertThrows(ArrayIndexOutOfBoundsException.class, ()->service.divide(10, 0));
//	}

}
