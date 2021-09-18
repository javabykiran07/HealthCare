package com.kiran.healthcare;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.kiran.healthcare.entity.Specialization;
import com.kiran.healthcare.repository.SpecializationRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class SpecializationRepoTest {
	@Autowired
	private SpecializationRepository repository;

	@Test
	@Order(1)
	public void testSave() {
		Specialization specialization = new Specialization(null, "crdt", "cardialogist", "134bcjhahsccjhcc");
		specialization =repository.save(specialization);
		assertNotNull(specialization.getId(),"not created ");
	}

	@Test
	public void getAll() {
		List<Specialization> findAll = repository.findAll();
		assertNotNull(findAll);
	}
}
