package com.GypseePvtLtd.GypseeDemo.Service.ServiceTicketService;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.GypseePvtLtd.GypseeDemo.DAO.ServiceTicketJpaRepository;
import com.GypseePvtLtd.GypseeDemo.Entity.ServiceTicket;
import com.GypseePvtLtd.GypseeDemo.Service.LocationService.LocationService;

@Component
public class ServiceTicketServiceImpl implements ServiceTicketService {

	@Autowired
	ServiceTicketJpaRepository serviceTicketRepository;
	@Autowired
	LocationService service;
	
	@Override
	public ServiceTicket createServiceTicket(String carId,String lat,String lon,String description) {
		// TODO Auto-generated method stub
		Integer locationId=service.createLocation(lat, lon);
		ServiceTicket serviceTicket=serviceTicketRepository.save(new ServiceTicket(carId,locationId,description));
	   return serviceTicket;
	}

	@Override
	public ServiceTicket getServiceTicket(String serviceTicketId) {
		ServiceTicket serviceTicket=serviceTicketRepository.getReferenceById(serviceTicketId);
		return serviceTicket;
	}

	@Override
	public List<ServiceTicket> getAllByCarId(String carId) {
		// TODO Auto-generated method stub
		List<ServiceTicket> serviceTicketList= serviceTicketRepository.findByCarId(carId);
	return serviceTicketList;
	}

}
