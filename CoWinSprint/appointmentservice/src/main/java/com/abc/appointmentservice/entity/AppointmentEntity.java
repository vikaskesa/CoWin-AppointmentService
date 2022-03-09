package com.abc.appointmentservice.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

@Entity
@Table(name="appointment_table")
public class AppointmentEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="appointment_id")
	private int appointmentId;
	
	@Column(name="type_of_vaccine")
	private String typeOfVaccine;
	
	@Column(name="date_of_appointment")
	private LocalDate dateOfAppointment;
	
	@Column(name="center_id")
	private int centerId;
	
	@Column(name="dose_number")
	private int doseNumber;
	
	@Column(name="user_id")
	private int userId;

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
		

}