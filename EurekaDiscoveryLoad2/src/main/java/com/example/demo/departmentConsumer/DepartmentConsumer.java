package com.example.demo.departmentConsumer;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Employee;

@Component
public class DepartmentConsumer {
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;

	public String getConsumerEmployee() {
		
		List<ServiceInstance> serviceList = discoveryClient.getInstances("EurekaDiscoveryLoad1");
		
		ServiceInstance instance = serviceList.get(0);
		
		URI uri = instance.getUri();
		
		String url = uri+"/emp/getEmployeeData";
		
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<String> response= restTemplate.getForEntity(url, String.class);
		
		String responseData = response.getBody();
		
		return responseData;
		
	}
	
	public String getAllEmployees() {
		ServiceInstance serviceInstance = loadBalancerClient.choose("EurekaDiscoveryLoad1");
		
		URI uri = serviceInstance.getUri();
		
		String url = uri+"/emp/getEmployeeData";
		
		RestTemplate restTemplate = new RestTemplate();
	    ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
	    
	    String responseData = response.getBody();
	    
	    return responseData;
		
	}
	
	public Object getAllData() {
	ServiceInstance serviceInstance = loadBalancerClient.choose("EurekaDiscoveryLoad1");
	URI uri = serviceInstance.getUri();
	
	String url = uri+"/emp/getAllEmployee";
	
	RestTemplate restTemplate = new RestTemplate();
	Object response = restTemplate.getForObject(url, Object.class);
//    Object responseData = response.getBody();
    
    return response;
	}
	
	public Object getAllShowRoomInfo() {
		ServiceInstance serviceInstance = loadBalancerClient.choose("SpringBootMicro1");
		
		URI uri = serviceInstance.getUri();
		
		String url = uri+"/showRoom/getShowRoomData";
		
		RestTemplate restTemplate = new RestTemplate();
		Object objectResponse = restTemplate.getForObject(url, Object.class);
		
		return objectResponse;
	}
}
