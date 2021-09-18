package com.kiran.healthcare.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Spec_tab")
public class Specialization {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "spec_id_col")
	private Long id;
	@Column(name = "specName_col")
	private String specName;
	@Column(name = "specCode_col")
	private String specCode ;
	@Column(name = "specNote_col")
	private String specNote;
	

}
