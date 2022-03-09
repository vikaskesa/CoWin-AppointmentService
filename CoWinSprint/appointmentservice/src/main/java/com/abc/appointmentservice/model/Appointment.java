package com.abc.appointmentservice.model;

import java.time.LocalDate;


public class Appointment {
private int appointmentId;
	
	private String typeOfVaccine;
	
	private LocalDate dateOfAppointment;
	
	private int centerId;
	
	private int doseNumber;
	
	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public String getTypeOfVaccine() {
		return typeOfVaccine;
	}

	public void setTypeOfVaccine(String typeOfVaccine) {
		this.typeOfVaccine = typeOfVaccine;
	}

	public LocalDate getDateOfAppointment() {
		return dateOfAppointment;
	}

	public void setDateOfAppointment(LocalDate dateOfAppointment) {
		this.dateOfAppointment = dateOfAppointment;
	}

	public int getCenterId() {
		return centerId;
	}

	public void setCenterId(int centerId) {
		this.centerId = centerId;
	}

	public int getDoseNumber() {
		return doseNumber;
	}

	public void setDoseNumber(int doseNumber) {
		this.doseNumber = doseNumber;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	private int userId;
}
