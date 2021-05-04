package com.cognizant.component.processing.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="defective_component_details")
public class DefectiveComponentDetails {
    @Id
    @GeneratedValue
    @Column(name="component_id")
    private int componentId;
    @Column(name="component_type") 
    @Enumerated(EnumType.STRING)
	private ComponentType componentType;
    @Column(name="component_name")
	private String componentName;
    @Column(name="quantity")
	private int quantity;
}
