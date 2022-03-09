package com.abc.appointmentservice.model;


public class AppointmentDetails {
	private User user;
	private VaccinationCenter vaccinationCenter;
	private Appointment appointment;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public VaccinationCenter getVaccinationCenter() {
		return vaccinationCenter;
	}
	public void setVaccinationCenter(VaccinationCenter vaccinationCenter) {
		this.vaccinationCenter = vaccinationCenter;
	}
	public Appointment getAppointment() {
		return appointment;
	}
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

}
