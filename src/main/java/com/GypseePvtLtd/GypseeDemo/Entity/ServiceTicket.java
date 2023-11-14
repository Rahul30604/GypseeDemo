package com.GypseePvtLtd.GypseeDemo.Entity;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="serviceTicket")
public class ServiceTicket {
	@Id
	@UuidGenerator
	@Column(name="service_ticket_id")
	private String serviceTicektId;
	@Column(name="car_id")
	private String carId;
	@Column(name="location_id")
	private Integer locationid;
	@Column(name="description")
	private String description;
	
	//constructors
	public ServiceTicket(String carId, Integer locationid, String description) {
		super();
		this.carId = carId;
		this.locationid = locationid;
		this.description = description;
	}

	public ServiceTicket() {
		super();
	}
	//getters and setters

	public String getServiceTicektId() {
		return serviceTicektId;
	}

	public void setServiceTicektId(String serviceTicektId) {
		this.serviceTicektId = serviceTicektId;
	}

	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	public Integer getLocationid() {
		return locationid;
	}

	public void setLocationid(Integer locationid) {
		this.locationid = locationid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	

}
