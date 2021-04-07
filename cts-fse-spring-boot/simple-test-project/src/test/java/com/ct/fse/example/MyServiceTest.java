package com.ct.fse.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyServiceTest {

	@Test
	void testAdd() {
		MyService service=new MyService();
		assertEquals(15, service.add(5, 10));
	}

}
