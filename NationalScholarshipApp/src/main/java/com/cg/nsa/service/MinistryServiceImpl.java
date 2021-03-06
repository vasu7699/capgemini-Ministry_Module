package com.cg.nsa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.nsa.entity.Ministry;
import com.cg.nsa.entity.Scholarship;
import com.cg.nsa.exception.IdNotFoundException;
import com.cg.nsa.exception.UserIdAlreadyFoundException;
import com.cg.nsa.repository.IMinistryRepository;

/**
 * Description Implementation of IMinistryService(Service Interface)
 * @author VASUPRADHA
 *
 */
@Service
public class MinistryServiceImpl implements IMinistryService{
	
	@Autowired
	
	IMinistryRepository dao;
	
	/**
	 * Description Service method to check whether to grant the scholarship
	 * @paramScholarship
	 * @return Scholarship
	 */
    @Override
	public Scholarship grant(Scholarship scholarship) {
		// TODO Auto-generated method stub
		 if(scholarship!=null) {
			 if(scholarship.getApproval().equalsIgnoreCase("approved")) {
				 return scholarship;
			 }
			 
			 else {
				 return null;
			 }
		 }
		 
		else {
			throw new IdNotFoundException("Id Not Found"); 
		 }
	}
    
    
    
    /**
     * Description Service Method to Get All Ministry Details
     * @return Ministry List
     */

	@Override
	public List<Ministry> getAll() {
		// TODO Auto-generated method stub
		return dao.findAll() ;
	}
	
	
	
	/**
	 * Description Service Method to Add ministry details
	 * @param Ministry Object
	 * @return Ministry Object
	 */

	@Override
	public Ministry addMinistry(Ministry ministry) {
		// TODO Auto-generated method stub
	    String Id=ministry.getUserId();
	    int flag=0;
	    List<Ministry> mlist=dao.findAll();
		for(Ministry m:mlist) {
			if(m.getUserId().equalsIgnoreCase(Id)) {
				flag=1;
			}
			
		}
		
		if(flag==0) {
			return dao.save(ministry);
		}
		else {
			throw new UserIdAlreadyFoundException("UserId Cannot Be Repeated");
		}
		}
	
	
	
}