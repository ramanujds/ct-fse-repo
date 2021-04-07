package com.ct.springboot.covidinfo.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ct.springboot.covidinfo.model.CountryInfo;
@SpringBootTest
class CovidInfoServiceTest {

	@Autowired
	CovidInfoService service;
	
	@Test
	void testGetCountryInfo() {
		CountryInfo countryInfo=service.getCountryInfo("india");
		System.out.println(countryInfo);
	}

}
