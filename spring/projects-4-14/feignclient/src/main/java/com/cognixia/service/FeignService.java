package com.cognixia.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@FeignClient("eureka-client") 
public interface FeignService {
	   @GetMapping("/hello") 
	   String sayHello(); 
}

