package id.co.acc.domain.exceptions;

import org.springframework.security.core.AuthenticationException;

public class AuthorizationException extends CustomRuntimeException {

	private static final long serialVersionUID = -3439496890608068422L;

//	public AuthorizationException(String code, String message) {
//		super(code, message);
//	}

	public AuthorizationException(String message) {
		super("F", message);
	}
}
