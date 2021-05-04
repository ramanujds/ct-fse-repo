package com.cognizant.component.processing.model;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="process_request")
public class ProcessRequest {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO) 
    @Column(name="user_id")
    private int userId;
    @Column(name="user_name")
	private String userName;
    @Column(name="contact_number")
	private long contactNumber;
    @Column(name="credit_card_number")
	private long creditCardNumber;
    @JoinColumn(name="defective_component_details")
    @OneToOne(cascade = CascadeType.ALL)
	private DefectiveComponentDetails defectiveComponentDetails;
    @Column(name="is_priority_request")
	private boolean isPriorityRequest;
}
