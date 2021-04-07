package com.ct.springboot.restapi.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@XmlRootElement
//@AllArgsConstructor
//@Getter
//@Setter
//@NoArgsConstructor
//@ToString
//@EqualsAndHashCode

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Size(min = 5, message = "Name must contain atleast 5 characters")
	
	private String employeeName;
	private String email;
	//@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;
	
}
