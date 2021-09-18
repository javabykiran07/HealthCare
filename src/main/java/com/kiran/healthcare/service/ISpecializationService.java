package com.kiran.healthcare.service;

import java.util.List;

import com.kiran.healthcare.entity.Specialization;

public interface ISpecializationService {
	
	Long saveSpecialization(Specialization specialization);
		List<Specialization> getAll();
	void removeSpecialization(Long id);
	void updateSpecialization( Specialization specialization);
	
	Specialization  getOneSpecialization(Long id);
	
	

}
