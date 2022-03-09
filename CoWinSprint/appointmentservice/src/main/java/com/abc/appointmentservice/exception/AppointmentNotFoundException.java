package com.abc.appointmentservice.exception;

public class AppointmentNotFoundException extends RuntimeException{
	public AppointmentNotFoundException(String str) {
		super(str);
	}

}
