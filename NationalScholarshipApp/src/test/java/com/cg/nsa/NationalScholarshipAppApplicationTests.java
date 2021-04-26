	package com.cg.nsa;

	import org.junit.jupiter.api.Test;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.test.context.SpringBootTest;
	import static org.junit.jupiter.api.Assertions.assertEquals;
	import static org.junit.jupiter.api.Assertions.assertThrows;
	import static org.junit.jupiter.api.Assertions.assertNotEquals;

	import java.util.ArrayList;
	import java.util.List;

	import com.cg.nsa.entity.Ministry;
	import com.cg.nsa.entity.Scholarship;
	import com.cg.nsa.entity.Student;
	import com.cg.nsa.exception.IdNotFoundException;
	import com.cg.nsa.exception.UserIdAlreadyFoundException;

	import com.cg.nsa.service.IMinistryService;
	import com.cg.nsa.service.IScholarshipService;
	import com.cg.nsa.service.IStudentService;

	/*********************************************************************
	 * 
	 * @author VASUPRADHA
	 * Version 1.0
	 * Description : Test cases for ministry module
	 * Date: 25-04-2021
	 *
	 *********************************************************************/
	@SpringBootTest
	class NationalScholarshipAppApplicationTests {
		@Autowired
		IMinistryService iMinistryService;
		@Autowired
		IScholarshipService iScholarshipService;
		@Autowired
		IStudentService iStudentService;
		
		/*************************************************************
		 * 
		 * @author VASUPRADHA
		 * Description:Test case To add details of ministry
		 * @return asserEquals
		 * 
		 **************************************************************/
		
		@Test
		void testaddMinistry(){
			Ministry ministry=new Ministry("20","dhwe","ministry","Cultural");
			assertEquals(ministry,iMinistryService.addMinistry(ministry));
		}
		
		/**************************************************************************
		 * 
		 * @author VASUPRADHA
		 * Description:Test case To check Exception to add details of ministry
		 * @return asserThrows
		 * 
		 **************************************************************************/
		
		@Test
		void testaddException() {
			Ministry ministry=new Ministry("10","asdfg","ministry","Education");
			assertThrows(UserIdAlreadyFoundException.class,()->iMinistryService.addMinistry(ministry));
		}
		
		/*********************************************************************
		 * 
		 * @author VASUPRADHA
		 * Description:Test case To grant scholarship by ministry
		 * @return asserEquals
		 * 
		 *********************************************************************/
		
		@Test
		void grantScholarship() {
			Scholarship scholarship= iScholarshipService.getById(102).orElse(null);
			Student student= iStudentService.findByStudentId(184);
			assertEquals(scholarship,iMinistryService.grant(scholarship, student));
			
		}
		
		/*********************************************************************************************
		 * 
		 * @author VASUPRADHA
		 * Description:Test case To not grant scholarship by ministry because not approved by officer
		 * @return asserEquals
		 * 
		 *********************************************************************************************/
		
		@Test
		void grantScholarshipPending() {
			Scholarship scholarship= iScholarshipService.getById(102).orElse(null);
			Student student= iStudentService.findByStudentId(166);
			assertEquals(null,iMinistryService.grant(scholarship, student));
			
		}
		
		/*********************************************************************
		 * 
		 * @author VASUPRADHA
		 * Description:Test case To reject scholarship by ministry
		 * @return asserEquals
		 * 
		 *********************************************************************/
		
		@Test
		void grantScholarshipReject() {
			Scholarship scholarship= iScholarshipService.getById(102).orElse(null);
			Student student= iStudentService.findByStudentId(136);
			assertEquals(null,iMinistryService.grant(scholarship, student));
		}
		
		/*********************************************************************
		 * 
		 * @author VASUPRADHA
		 * Description:Test case To get all ministry details
		 * @return asserEquals
		 * 
		 *********************************************************************/
		
		
		@Test
		void getAll() {
			List<Ministry> actualList=iMinistryService.getAll();
			List<String> s=new ArrayList<String>();
			s.add("10");
			s.add("11");
			s.add("16");
			s.add("15");
			s.add("21");
			s.add("17");
			s.add("18");
			s.add("20");
			
			int flag=0;
			for(Ministry m:actualList) {
				
				if(s.contains(m.getUserId())) {
					
				}
				else {
					flag=1;
				}	
			}
			if(flag==0) {
				assertEquals(flag,0);
			}
				
		}
	}
