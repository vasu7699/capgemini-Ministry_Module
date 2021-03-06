package com.cg.nsa.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.cg.nsa.entity.Ministry;
import com.cg.nsa.entity.Scholarship;

/**
 * Description Service Interface
 * @author VASUPRADHA
 *
 */

@Service
public interface IMinistryService {
	
	public Scholarship grant(Scholarship scholarship);
	public List<Ministry> getAll();
	public Ministry addMinistry(Ministry ministry);
	
}
