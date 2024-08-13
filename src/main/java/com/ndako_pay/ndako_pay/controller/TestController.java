package com.ndako_pay.ndako_pay.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ndekocash")
public class TestController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String home() {
		return "test loll";
	}

}
