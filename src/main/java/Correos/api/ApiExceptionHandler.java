package Correos.api;

import Correos.api.exception.ApiBusinessException;
import Correos.api.exception.BadRequestException;
import Correos.api.exception.InternalServerErrorException;
import Correos.api.exception.MethodNotAllowedException;
import Correos.api.exception.NotFoundException;
import Correos.api.exception.UnprocessableEntityException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(ApiBusinessException.class)
    public ResponseEntity<ApiResponse> handleBusiness(ApiBusinessException ex, HttpServletRequest request) {
        return ResponseEntity.status(ex.getCodigo()).body(ex.toResponse());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> handleValidation(MethodArgumentNotValidException ex, HttpServletRequest request) {
        return handleBusiness(new UnprocessableEntityException(ex), request);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiResponse> handleBadRequest(HttpMessageNotReadableException ex, HttpServletRequest request) {
        return handleBusiness(new BadRequestException(ex), request);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ApiResponse> handleNotFound(NoHandlerFoundException ex, HttpServletRequest request) {
        return handleBusiness(new NotFoundException(ex), request);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ApiResponse> handleMethodNotAllowed(HttpRequestMethodNotSupportedException ex, HttpServletRequest request) {
        return handleBusiness(new MethodNotAllowedException(ex), request);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleUnexpected(Exception ex, HttpServletRequest request) {
        return handleBusiness(new InternalServerErrorException(ex), request);
    }

}
