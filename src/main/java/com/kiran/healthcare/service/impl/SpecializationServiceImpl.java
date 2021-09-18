package com.kiran.healthcare.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kiran.healthcare.entity.Specialization;
import com.kiran.healthcare.repository.SpecializationRepository;
import com.kiran.healthcare.service.ISpecializationService;

@Service
public class SpecializationServiceImpl implements ISpecializationService {
	@Autowired
	private SpecializationRepository repo;

	@Override
	public Long saveSpecialization(Specialization specialization) {

		return repo.save(specialization).getId();
	}

	@Override
	public List<Specialization> getAll() {

		return repo.findAll();
	}

	@Override
	public void removeSpecialization(Long id) {

		// Specialization specialization = repo.getById(id);

		// repo.delete(specialization);

		repo.deleteById(id);
	}

	@Override
	public void updateSpecialization(Specialization specialization) {

		repo.save(specialization);
	}

	@Override
	public Specialization getOneSpecialization(Long id) {
		Optional<Specialization> optional = repo.findById(id);

		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}

	}

}
