package com.ct.microservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ct.microservices.model.Recipe;
import com.ct.microservices.model.RecipeMenu;

@Service
public class RecipeService {

	@Autowired
	RestTemplate rt;
	
	public RecipeMenu getRecipe(String itemName) {
		RecipeMenu recipe=rt.getForObject("https://www.themealdb.com/api/json/v1/1/search.php?s="+itemName, RecipeMenu.class);
		return recipe;
	}
	
}
