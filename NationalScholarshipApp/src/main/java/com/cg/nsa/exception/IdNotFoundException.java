package com.cg.nsa.exception;


/*************************************************************************************
 * Description Exception Implementation To check whether the Scholarship Id is valid 
 * @author VASUPRADHA
 ***************************************************************************************/

public class IdNotFoundException extends RuntimeException{
	public IdNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	public IdNotFoundException(String msg)
	{
		super(msg);
	}
}