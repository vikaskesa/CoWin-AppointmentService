package com.abc.appointmentservice.service;


import java.util.List;

import com.abc.appointmentservice.model.Appointment;
import com.abc.appointmentservice.model.AppointmentDetails;

public interface AppointmentService {
	public Appointment bookAppointment(Appointment appointment);
	
	public void cancelAppointment(int appointmentId);
	
	public Appointment viewAppointmentbyId(int appointmentId);
	
	public Appointment updateAppointment(Appointment appointment);
	
	public AppointmentDetails viewAppointmentdetails(int appointmentId);

}
