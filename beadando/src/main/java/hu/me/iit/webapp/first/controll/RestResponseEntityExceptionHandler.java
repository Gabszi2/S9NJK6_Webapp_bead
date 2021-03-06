package hu.me.iit.webapp.first.controll;

import hu.me.iit.webapp.first.service.NoSuchEntityException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {NoSuchEntityException.class})
    protected ResponseEntity<Object> handleNoSuchElement(NoSuchEntityException exception, WebRequest request){
    return handleExceptionInternal(exception,exception.getMessage(),new HttpHeaders(), HttpStatus.NOT_FOUND,request);
    }

}
