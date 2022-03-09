package com.abc.appointmentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.appointmentservice.model.Appointment;
import com.abc.appointmentservice.model.AppointmentDetails;
import com.abc.appointmentservice.service.AppointmentService;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
	
	@Autowired
	private AppointmentService appointmentService;
	
	@PostMapping("/save")
	public ResponseEntity<Appointment> saveAppointment(@RequestBody Appointment appointment){

		Appointment newAppointment=appointmentService.bookAppointment(appointment);
		return new ResponseEntity<>(newAppointment,HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/delete/{pid}")
	public ResponseEntity<?> deleteAppointmentById(@PathVariable("pid") int appointmentId){
		appointmentService.cancelAppointment(appointmentId);
		return new ResponseEntity<>("Deleted product with id :"+appointmentId,HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Appointment> fetchAppointmentById(@PathVariable("id") int appointmentId){
		Appointment appointment=appointmentService.viewAppointmentbyId(appointmentId);
		return new ResponseEntity<>(appointment,HttpStatus.OK);
			
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<Appointment> modifyAppointment(@RequestBody Appointment appointment) {
		Appointment updatedAppointment = appointmentService.updateAppointment(appointment);
		return new ResponseEntity<>(updatedAppointment, HttpStatus.OK);
	}
	
	@GetMapping("/getbyid/{pid}")
	public ResponseEntity<AppointmentDetails> fetchAppointment(@PathVariable("pid") int appointmentId) {
		AppointmentDetails appointmentDetails=appointmentService.viewAppointmentdetails(appointmentId);
		return new ResponseEntity<>(appointmentDetails,HttpStatus.OK);
}
}
