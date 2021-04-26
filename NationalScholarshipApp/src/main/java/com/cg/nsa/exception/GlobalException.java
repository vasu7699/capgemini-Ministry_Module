	package com.cg.nsa.exception;

	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.ExceptionHandler;
	import org.springframework.web.bind.annotation.RestControllerAdvice;

	/***************************************************
	 * 
	 * @author VASUPRADHA
	 * Description: This is GlobalException class for Ministry Module.
	 * Created Date:24-04-2021
	 * 
	 *************************************************/

	@RestControllerAdvice
	public class GlobalException {
		/************************************************************
		 * 
		 * @param exception
		 * @return - error messages
		 *
		 *************************************************************/
		@ExceptionHandler(IdNotFoundException.class)
		public ResponseEntity<Object> handleException(IdNotFoundException exception)
		{
			return new ResponseEntity<Object>(exception.getMessage(),HttpStatus.NOT_FOUND);
		}
		
		
		/******************************************************************
		 * 
		 * @param exception
		 * @return error messages
		 * 
		 ******************************************************************/
		@ExceptionHandler(UserIdAlreadyFoundException.class)
		public ResponseEntity<Object> handleException(UserIdAlreadyFoundException exception)
		{
			return new ResponseEntity<Object>(exception.getMessage(),HttpStatus.NOT_FOUND);
		}
		
		/*******************************************************************************************
		 * 
		 * @param exception
		 * @return validation error messages
		 * 
		 *********************************************************************************************/
		@ExceptionHandler(ValidationException.class)
		public ResponseEntity<Object> handleException(ValidationException exception){
				return new ResponseEntity<Object>(exception.getMessages(),HttpStatus.NOT_FOUND);
		}
	}