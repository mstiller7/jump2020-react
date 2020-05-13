package com.cognixia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.service.FeignService;

@RestController
public class FeignController {

	@Autowired
	FeignService service;
	
	@GetMapping
	public String getResult()
	{
		System.out.println("Inside getResult FeignController");
		return service.sayHello();
	}
	
}
