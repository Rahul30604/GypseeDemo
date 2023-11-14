package com.GypseePvtLtd.GypseeDemo.Controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.GypseePvtLtd.GypseeDemo.Entity.ServiceTicket;
import com.GypseePvtLtd.GypseeDemo.Service.ServiceTicketService.ServiceTicketServiceImpl;

@RestController
public class ServiceTicketController {
	@Autowired
	ServiceTicketServiceImpl serviceTicketServiceImpl;
	
	
	@PostMapping("/cars/{carId}/serviceTicket/{lat}/{lon}")
	public ResponseEntity<Object> createServiceTicket(@PathVariable String carId,@PathVariable String lat,@PathVariable String lon, @RequestBody String description) {
		ServiceTicket serviceTicket=serviceTicketServiceImpl.createServiceTicket(carId, lat, lon, description);
		return new ResponseEntity( HttpStatus.CREATED);
	     
	}
	
	@GetMapping("/cars/{carId}/serviceTicket/{serviceTicketId}")
	public ServiceTicket getServiecTicket(@PathVariable String carId,@PathVariable String serviceTicketId) {
		return serviceTicketServiceImpl.getServiceTicket(serviceTicketId);
	}
	
	@GetMapping("/cars/{carId}/serviceTicket")
	public List<ServiceTicket> getAllServiceTicket(@PathVariable String carId) {
		return serviceTicketServiceImpl.getAllByCarId(carId);
	}
	
	

}
