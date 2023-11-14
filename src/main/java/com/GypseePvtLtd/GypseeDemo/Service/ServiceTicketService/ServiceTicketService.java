package com.GypseePvtLtd.GypseeDemo.Service.ServiceTicketService;

import java.util.List;

import com.GypseePvtLtd.GypseeDemo.Entity.ServiceTicket;

public interface ServiceTicketService {
	public ServiceTicket createServiceTicket(String carId,String lat,String lon,String Description);
	public ServiceTicket getServiceTicket(String serviceTicketId);
	public List<ServiceTicket> getAllByCarId(String carId);

}
