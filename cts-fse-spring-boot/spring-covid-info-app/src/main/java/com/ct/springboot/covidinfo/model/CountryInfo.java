package com.ct.springboot.covidinfo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryInfo {

	private CovidData confirmed;
	
	private CovidData deaths;
	
	private CovidData recovered;
	
	private String lastUpdate;
	
	
}
