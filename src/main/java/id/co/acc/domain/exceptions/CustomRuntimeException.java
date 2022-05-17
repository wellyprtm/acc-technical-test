package id.co.acc.domain.exceptions;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomRuntimeException extends RuntimeException {

	private static final long serialVersionUID = -7794440673058695344L;
	
	protected String code;
	protected String message;

	public CustomRuntimeException(String code, String message) {
		super(code);
		this.code = code;
		this.message = message;

	}
	
	public String getStackTraceAsString(Exception e) {
		String stackTrace = "";
		
		if (e != null) {
			stackTrace = "Exception class: " + e.getClass().getName() + "\nMessage: " + e.getMessage() + "\nCause: " + e.getCause() + "\nStack trace: ";
			for (StackTraceElement ste : e.getStackTrace()) {
				stackTrace += ste.toString() + " \n";
			}
		}

		return stackTrace;
	}
}
