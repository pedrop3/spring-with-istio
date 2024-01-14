package com.learn.istio.demo2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class BaseController {

    private final RestTemplate restTemplate;

    @GetMapping("/service-2")
	public String getValues() {
		return "Getting Called by Service 2";
	}
	
	@GetMapping("/service-2-1")
	public String callService1() {
		String val = restTemplate.getForObject("http://localhost:8080/service-1", String.class);
		return "Service call from service 2 to service 1 --- " + val;
	}
    
}
