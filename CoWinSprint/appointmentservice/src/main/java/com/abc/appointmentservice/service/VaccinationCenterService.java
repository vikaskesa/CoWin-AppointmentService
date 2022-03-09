package com.abc.appointmentservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.abc.appointmentservice.model.User;
import com.abc.appointmentservice.model.VaccinationCenter;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
@Service
public class VaccinationCenterService {
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "getVaccinationcenterDetailsFallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000"), })
	public VaccinationCenter getVaccinationCenterDetails(int centerId) {
	VaccinationCenter vaccinationCenter = null;

	String resourceUrl = "http://productservice/project/product/get/" + centerId;

	ResponseEntity<VaccinationCenter> productResponseEntity = restTemplate.getForEntity(resourceUrl, VaccinationCenter.class);

	if (productResponseEntity.getStatusCode() == HttpStatus.OK) {
		vaccinationCenter = productResponseEntity.getBody();

		return vaccinationCenter;
	}
	return vaccinationCenter;
	}
	@SuppressWarnings("unused")
	private VaccinationCenter getVaccinationcenterDetailsFallback(int centerId) {
	VaccinationCenter vaccinationCenter=new VaccinationCenter();
	vaccinationCenter.setCenterId(0);
	vaccinationCenter.setCenterName("");
	vaccinationCenter.setDistrict("");
	vaccinationCenter.setPincode(0);
	vaccinationCenter.setState("");
	return vaccinationCenter;
        	}

}
