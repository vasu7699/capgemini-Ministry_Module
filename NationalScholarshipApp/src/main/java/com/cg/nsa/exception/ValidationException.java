package com.cg.nsa.exception;

import java.util.ArrayList;
import java.util.List;
/*********************************************************
 * 
 * @author VASUPRADHA
 * Description: validation exception
 *
 ************************************************************/
public class ValidationException extends RuntimeException {
	List<String> messages=new ArrayList<String>();
	public ValidationException() {
		
	}
	public ValidationException(List<String> messages) {
		super();
		this.messages=messages;
		
	}
	
	public List<String> getMessages(){
		return messages;
	}

}
