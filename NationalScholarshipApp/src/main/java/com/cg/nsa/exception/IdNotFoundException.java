	package com.cg.nsa.exception;


	/*************************************************************************************
	 * 
	 * Description Exception Implementation To check whether the Scholarship Id is valid 
	 * @author VASUPRADHA
	 * 
	 ***************************************************************************************/

	public class IdNotFoundException extends RuntimeException{
		public IdNotFoundException() {

		}
		public IdNotFoundException(String msg)
		{
			super(msg);
		}
	}