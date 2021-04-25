package com.cg.nsa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cg.nsa.entity.Scholarship;

/************************************************
 * Description Scholarship Service Interface
 * @author VASUPRADHA
 *
 ************************************************/
@Service
public interface IScholarshipService {

	//Scholarship statusUpdate(Scholarship scholarship);

	List<Scholarship> getAllScholarships();

	Optional<Scholarship> getById(int scholarshipId);
	
}
