package com.ct.springboot.restapi.dto;

import java.time.LocalDate;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@XmlRootElement
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

	private int id;
	
	@NotBlank
	@NotEmpty
	@Size(min = 5, max=10, message = "Name must contain 5-10 characters")
	private String employeeName;
	private String email;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;
	private int age;
	

	
	
}
