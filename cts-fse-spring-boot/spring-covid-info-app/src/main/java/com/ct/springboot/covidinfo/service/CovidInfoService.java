package com.ct.springboot.covidinfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ct.springboot.covidinfo.model.CountryInfo;

@Service
public class CovidInfoService {

	@Autowired
	RestTemplate rt;
	
	
	public CountryInfo getCountryInfo(String country) {
		return rt.getForObject("https://covid19.mathdro.id/api/countries/"+country, CountryInfo.class);
	}
	
	
}
