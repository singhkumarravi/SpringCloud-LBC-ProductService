package com.olive.consumer;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProductRestConsumer {
	@Autowired
    private  LoadBalancerClient cl;
	
	public String getData() {
	    ServiceInstance si = cl.choose("VENDOR-APP");   
	     String url=si.getUri()+"/vendor/msg";
		 String resp = new RestTemplate().getForObject(url, String.class);
		return resp;
	}
	
}
