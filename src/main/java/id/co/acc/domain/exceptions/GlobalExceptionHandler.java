package id.co.acc.domain.exceptions;

import id.co.acc.domain.base.dtos.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(value = HttpStatus.OK)
    public ApiResponse handleBadRequestException(HttpServletRequest request, BadRequestException e) {
        return ApiResponse.error("F", e.getMessage());
    }

    @ExceptionHandler(AuthorizationException.class)
    @ResponseStatus(value =  HttpStatus.OK)
    public ApiResponse handleAuthorizationException(HttpServletRequest request, AuthorizationException e) {
        return ApiResponse.error("F", e.getMessage());
    }
}
