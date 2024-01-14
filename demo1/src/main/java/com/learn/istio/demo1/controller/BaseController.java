package com.learn.istio.demo1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class BaseController {
    
	private final RestTemplate restTemplate;

    @GetMapping("/service-1")
	public String getValues() {
		return "Getting Called by Service 1";
	}

    @GetMapping("/service-1-2")
	public String getValueFromService2() {
		String val = restTemplate.getForObject("http://localhost:8081/service-2", String.class);
		return "Service call from service 1 to service 2 --- " + val;
	}
}
