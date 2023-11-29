package com.B.M.hospitalappointmentsystem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppointmentExceptionController {
   @ExceptionHandler(value = AppointmentNotFoundException.class)
   public ResponseEntity<Object> exception(AppointmentNotFoundException exception) {
      return new ResponseEntity<>("Appointment not found", HttpStatus.NOT_FOUND);
   }
}