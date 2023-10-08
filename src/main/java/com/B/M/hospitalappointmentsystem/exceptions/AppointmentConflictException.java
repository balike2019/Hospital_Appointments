package com.B.M.hospitalappointmentsystem.exceptions;

public class AppointmentConflictException extends RuntimeException{
    public AppointmentConflictException(String message) {
        super(message);
    }
}
