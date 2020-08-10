package com.mcw.mycarwash.Controller;

import com.mcw.mycarwash.Exceptions.ApplicationError;
import com.mcw.mycarwash.Exceptions.CustomerNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomerNotFound.class)
    public ResponseEntity<ApplicationError> customerNitFoundException(CustomerNotFound customerNotFound, WebRequest webRequest){

        ApplicationError error = new ApplicationError();
        error.setCode(101);
        error.setMessage(customerNotFound.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
