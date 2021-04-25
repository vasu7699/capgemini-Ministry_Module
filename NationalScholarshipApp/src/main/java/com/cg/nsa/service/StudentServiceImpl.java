package com.cg.nsa.service;

import com.cg.nsa.entity.Student;
import org.springframework.stereotype.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import com.cg.nsa.repository.IStudentRepository;

/*****************************************************
 * @author VASUPRADHA
 * Description: Student service Implementation
 **********************************************************/
@Service
public class StudentServiceImpl implements IStudentService {
	@Autowired
	IStudentRepository studentDao;
	
	/**************************************************
	 * Description: Find student by user id
	 * @param userId
	 * @return student
	 *******************************************************/

	@Override
	public Optional<Student> getStudentById(String userId) {
		// TODO Auto-generated method stub
		return studentDao.findById(userId);
	}
	
	/*************************************************************
	 *  Description: Find student by student id
	 * @param studentId
	 * @return student
	 ***************************************************************/


	@Override
	public Student findByStudentId(int studentId) {
		// TODO Auto-generated method stub
		return studentDao.findByStudentId(studentId);
	}

}