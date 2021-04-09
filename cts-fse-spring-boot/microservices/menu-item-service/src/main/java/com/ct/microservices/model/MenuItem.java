package com.ct.microservices.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuItem {

	@Id
	@GeneratedValue
	private long id;
	private long menuItemId;
	private String itemName;
	private double price;
	@Transient
	private int port;
	@Transient
	private RecipeMenu recipe;

}
