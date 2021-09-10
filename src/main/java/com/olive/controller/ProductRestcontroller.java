package com.olive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.olive.consumer.ProductRestConsumer;

@RestController
@RequestMapping("/prod")
public class ProductRestcontroller {
	@Autowired
	private ProductRestConsumer consumer;
	
	@GetMapping("/data")
	public ResponseEntity<String> showProduct() {
		     String data= consumer.getData();
		     System.out.println("DATA :: " + data);
		return new ResponseEntity<String>("Call From Consumer App Product ::> " + data, HttpStatus.OK);
	}

}
