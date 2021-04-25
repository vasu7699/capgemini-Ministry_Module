package com.cg.nsa.service;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.nsa.entity.Scholarship;
import com.cg.nsa.repository.IScholarshipRepository;

/******************************************************************
 * Description Scholarship Service interface Implementation
 * @author VASUPRADHA
 *
 ********************************************************************/
@Service
public class ScholarshipServiceImpl implements IScholarshipService {
	@Autowired
	IScholarshipRepository scholarshipRepository;
	
	/**********************************************************************
	 * Description Get Scholarship from scholarshipId
	 * @param scholarshipId
	 * @return Scholarship object
	 ***********************************************************************/
	@Override
	public Optional<Scholarship> getById(int scholarshipId) {
		// TODO Auto-generated method stub
		return scholarshipRepository.findById(scholarshipId);
	}
	
	/***************************************************************************
	 * @return list of scholarships
	 * Description: All scholarship details
	 *****************************************************************************/
	@Override
	public List<Scholarship> getAllScholarships() {
		// TODO Auto-generated method stub
		return scholarshipRepository.findAll();
	}

}
