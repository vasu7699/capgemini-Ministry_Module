package com.cg.nsa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cg.nsa.entity.Student;
import com.cg.nsa.exception.InvalidInstitutionException;

/******************************************************
 * @author VASUPRADHA
 * Description: Student Service method
 ******************************************************/
@Service
public interface IStudentService {

	//Student addStudent(Student student);
	
	//Student editStudent(Student student);
	
	//List<Student> getAllStudents();
	
	//List<Student> getStudentsByInstitute(String name) throws InvalidInstitutionException;
	
	Optional<Student> getStudentById(String userId);
	
	Student findByStudentId(int studentId);
}
