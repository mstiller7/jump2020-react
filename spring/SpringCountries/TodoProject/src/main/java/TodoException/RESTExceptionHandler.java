package TodoException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RESTExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(TodoNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> TodoNotFound(TodoNotFoundException ex) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(), "Any details you would want to add");
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, new HttpHeaders(), HttpStatus.NOT_FOUND);
	}
	
	//Generic message
//  @ExceptionHandler(Exception.class)
//  public final ResponseEntity<ExceptionResponse> TodoNotFound(TodoNotFoundException ex) {
//  }
}