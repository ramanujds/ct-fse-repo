package com.cognizant.component.processing.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="process_response")
public class ProcessResponse {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="request_id")
	private int requestId;
	@Column(name="user_id")
	private int userId;
	@Column(name="processing_charge")
	private double processingCharge;
	@Column(name="packaging_and_delivery_charge")
	private double packagingAndDeliveryCharge;
	@Column(name="date_of_delivery")
	private LocalDate dateOfDelivery;
}
