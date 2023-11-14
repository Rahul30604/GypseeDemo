package com.GypseePvtLtd.GypseeDemo.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GypseePvtLtd.GypseeDemo.Entity.ServiceTicket;

public interface ServiceTicketJpaRepository extends JpaRepository<ServiceTicket, String>{

	public List<ServiceTicket> findByCarId(String carId);
}
