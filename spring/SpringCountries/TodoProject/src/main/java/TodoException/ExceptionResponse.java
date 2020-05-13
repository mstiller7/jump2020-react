package TodoException;

import java.util.Date;

public class ExceptionResponse {
	private Date timestamp = new Date();
	private String message;
	private String details;
	
	public ExceptionResponse(String message, String details) {
		super();
		this.message = message;
		this.details = details;
	}
	
}