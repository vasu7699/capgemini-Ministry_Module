package com.cg.nsa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.nsa.entity.Ministry;
import com.cg.nsa.entity.Scholarship;
import com.cg.nsa.service.IMinistryService;
import com.cg.nsa.service.IScholarshipService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@RestController
@Api(value="Ministry Api")
@RequestMapping(value="/MinistryApi")
/**
 * Description Ministry Controller
 * @author VASUPRADHA 
 *
 */
public class MinistryController{
	@Autowired
	IMinistryService ministryService;
	@Autowired
	IScholarshipService scholarshipService;
	
	/**
	 * Description Check whether the given scholarship is granted
	 * @param scholarshipId
	 * @return string
	 */
	@ApiOperation(value="Grant Scholarship")
	@GetMapping(value="/grantScholarship/{scholarshipId}")
	public String grant(@PathVariable int scholarshipId) {
		Scholarship scholarship=scholarshipService.getById(scholarshipId).orElse(null);
		Scholarship grant_Scholarship=ministryService.grant(scholarship);
		if(grant_Scholarship!=null) {
			String s="Scholarship is Granted"+"  Scholarship Id: "+scholarship.getScholarshipId()+"  Scholarship Name: "+scholarship.getScholarshipName();
			return s;
		}
		else {
			String s="Scholarship is Not Granted"+"  Scholarship Id: "+scholarship.getScholarshipId()+"  Scholarship Name: "+scholarship.getScholarshipName();
			return s;
		}
	}
	
	/**
	 * Description Get All the Ministry Details from database
	 * @return All Ministry details
	 */
	@ApiOperation(value="Get All Ministry")
	@GetMapping(value="/getAll")
	public List<Ministry> getAll(){
		return ministryService.getAll();
		
	}
	
	/**
	 * Description adds a new Ministry entry
	 * @param ministry
	 * @return Response Entity
	 */
	@ApiOperation(value="Add New Ministry")
	@PostMapping(value="/addMinistry")
	public ResponseEntity<Object> addMinitry(@RequestBody Ministry ministry){
		ministryService.addMinistry(ministry);
		return new ResponseEntity<Object>("Added", HttpStatus.OK);
	}
	
	
	
	
	
}