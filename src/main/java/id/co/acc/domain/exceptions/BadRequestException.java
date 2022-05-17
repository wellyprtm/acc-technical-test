package id.co.acc.domain.exceptions;

public class BadRequestException extends CustomRuntimeException{

    private static final long serialVersionUID = -3439496890608068421L;

    public BadRequestException(String code, String message) {
        super(code, message);
    }

    public BadRequestException(String message) {
        super("T", message);
    }
}
