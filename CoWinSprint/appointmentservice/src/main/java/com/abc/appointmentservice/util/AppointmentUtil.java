package com.abc.appointmentservice.util;


import java.util.ArrayList;
import java.util.List;

import com.abc.appointmentservice.entity.AppointmentEntity;
import com.abc.appointmentservice.model.Appointment;


public class AppointmentUtil {
	public static AppointmentEntity appointmentModelToEntity(Appointment appointment) {

		AppointmentEntity appointmentEntity=new AppointmentEntity();
		
		appointmentEntity.setAppointmentId(appointment.getAppointmentId());
		appointmentEntity.setCenterId(appointment.getCenterId());
		appointmentEntity.setDateOfAppointment(appointment.getDateOfAppointment());
		appointmentEntity.setDoseNumber(appointment.getDoseNumber());
		appointmentEntity.setTypeOfVaccine(appointment.getTypeOfVaccine());
		appointmentEntity.setUserId(appointment.getUserId());
		
		return appointmentEntity;
	}

	public static Appointment appointmentEntityToModel(AppointmentEntity appointmentEntity) {

		Appointment appointment=new Appointment();
		appointment.setAppointmentId(appointmentEntity.getAppointmentId());
		appointment.setCenterId(appointmentEntity.getCenterId());
		appointment.setDateOfAppointment(appointmentEntity.getDateOfAppointment());
		appointment.setDoseNumber(appointment.getDoseNumber());
		appointment.setTypeOfVaccine(appointment.getTypeOfVaccine());
		appointment.setUserId(appointmentEntity.getUserId());
		
		return appointment;
	}
	
	public static List<Appointment> appointmentEntityToModelList(List<AppointmentEntity> entityList) {
		
		List<Appointment> appointmentList = new ArrayList<>();
		
		entityList.forEach(entity -> {
			Appointment appointment=new Appointment();
			appointment.setAppointmentId(entity.getAppointmentId());
			appointment.setCenterId(entity.getCenterId());
			appointment.setDateOfAppointment(entity.getDateOfAppointment());
			appointment.setDoseNumber(entity.getDoseNumber());
			appointment.setTypeOfVaccine(entity.getTypeOfVaccine());
			appointment.setUserId(entity.getUserId());
		});
		
		return appointmentList;
	}
}
