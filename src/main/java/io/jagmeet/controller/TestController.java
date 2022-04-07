package io.jagmeet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jagmeet.model.TempData;
import io.jagmeet.service.DataService;

@RestController
@RequestMapping("/api")
public class TestController {

	@Autowired
	private DataService dataService;

	@GetMapping("/test")
	public TempData test() {
		return dataService.getDataFromEndPoint();
	}

}
