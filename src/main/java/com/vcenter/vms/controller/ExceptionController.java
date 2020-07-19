package com.vcenter.vms.controller;

import com.vcenter.vms.exception.ResourceNotAvailable;
import com.vcenter.vms.model.ResourceErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionController {

//    @ExceptionHandler(value = ResourceNotAvailable.class)
//    public ResponseEntity<Object> exception(ResourceNotAvailable exception) {
//        return new ResponseEntity<>( HttpStatus.INSUFFICIENT_STORAGE);
//    }

    @ExceptionHandler(ResourceNotAvailable.class)
    @ResponseBody
    ResponseEntity<?> handleControllerException(HttpServletRequest request, Throwable ex) {
        HttpStatus status = HttpStatus.INSUFFICIENT_STORAGE;
        ResourceErrorMessage resourceAllotFailed = new ResourceErrorMessage(LocalDateTime.now(), status.value(), ex.getMessage());
        return new ResponseEntity<>(resourceAllotFailed, status);
    }

}
