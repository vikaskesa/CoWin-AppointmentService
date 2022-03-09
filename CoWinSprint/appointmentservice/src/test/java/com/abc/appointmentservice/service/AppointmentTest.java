package com.abc.appointmentservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.abc.appointmentservice.entity.AppointmentEntity;
import com.abc.appointmentservice.model.Appointment;
import com.abc.appointmentservice.model.AppointmentDetails;
import com.abc.appointmentservice.repository.AppointmentRepository;
import com.abc.appointmentservice.service.AppointmentService;
import com.abc.appointmentservice.service.AppointmentServiceImpl;

@SpringBootTest
public class AppointmentTest {
	
	@InjectMocks
	AppointmentService appointmentService=new AppointmentServiceImpl();
	
	@Mock
	private UserService userService;
	
	@Mock
	private VaccinationCenterService vaccinationCenterService;
	
	@Mock
	private AppointmentRepository appointmentRepository;
	
	@Test
	public void testBookAppointment() {
		
		AppointmentEntity appointmentEntity=new AppointmentEntity();
		
		appointmentEntity.setAppointmentId(110);
		appointmentEntity.setCenterId(10);
		appointmentEntity.setDateOfAppointment(LocalDate.of(2020,10,12));
		appointmentEntity.setDoseNumber(2);
		appointmentEntity.setTypeOfVaccine("pfizer");
		appointmentEntity.setUserId(110);
		
		when(appointmentRepository.save(appointmentEntity)).thenReturn(appointmentEntity);
		Appointment appointment=new Appointment();
		Appointment existing=appointmentService.bookAppointment(appointment);
		verify(appointmentRepository,times(1)).save(appointmentEntity);
	}
	
	@Test
	public void testCancelAppointment() {
		
		int appointmentId=3;
		AppointmentEntity appointmentEntity=new AppointmentEntity();
		
		appointmentEntity.setAppointmentId(3);
		appointmentEntity.setCenterId(122);
		appointmentEntity.setDateOfAppointment(LocalDate.of(2020,10,12));
		appointmentEntity.setDoseNumber(1);
		appointmentEntity.setTypeOfVaccine("Covaxin");
		appointmentEntity.setUserId(10);
		
		Optional<AppointmentEntity> optional=Optional.of(appointmentEntity);
		when(appointmentRepository.findById(3)).thenReturn(optional);
		appointmentService.cancelAppointment(appointmentEntity.getAppointmentId());
		verify(appointmentRepository,times(1)).deleteById(appointmentId);
	}
	
	@Test
	public void testViewAppointment() {
		AppointmentEntity appointmentEntity=new AppointmentEntity();
		appointmentEntity.setAppointmentId(4);
		appointmentEntity.setCenterId(122);
		appointmentEntity.setDateOfAppointment(LocalDate.of(2020,10,12));
		appointmentEntity.setDoseNumber(1);
		appointmentEntity.setTypeOfVaccine("Covaxin");
		appointmentEntity.setUserId(10);
		
		int appointmentId=4;
		Optional<AppointmentEntity> optional=Optional.of(appointmentEntity);
		when(appointmentRepository.findById(4)).thenReturn(optional);
		
		AppointmentDetails existing=appointmentService.viewAppointmentdetails(appointmentId);
		
		assertEquals(appointmentEntity.getAppointmentId(),existing.getAppointment());	
	}
	
	@Test
	public void viewAppointmentDetails() {
		
	}

}
