package com.abc.appointmentservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.abc.appointmentservice.model.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
@Service
public class UserService {
	@Autowired
	private RestTemplate restTemplate;
	@HystrixCommand(fallbackMethod = "getUserDetailsFallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000"), })
	public User getUserDetails(int userId) {
	User user = null;

	String resourceUrl = "http://productservice/project/product/get/" + userId;

	ResponseEntity<User> productResponseEntity = restTemplate.getForEntity(resourceUrl, User.class);

	if (productResponseEntity.getStatusCode() == HttpStatus.OK) {
		user = productResponseEntity.getBody();

		return user;
	}
	return user;
	}
	@SuppressWarnings("unused")
	private User getUserDetailsFallback(int userId) {
	User user= new User();
	user.setUserId(0);
	user.setAddress("");
	user.setAge(0);
	user.setIdProof("");
	user.setMobileNumber("");
	user.setUserName("");
	return user;
        	}

}

