package com.kiran.healthcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kiran.healthcare.entity.Specialization;

public interface SpecializationRepository extends JpaRepository<Specialization, Long>{

}
