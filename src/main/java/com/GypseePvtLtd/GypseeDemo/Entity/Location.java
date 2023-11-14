package com.GypseePvtLtd.GypseeDemo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="userLocation")
public class Location {
	@Id
	@SequenceGenerator(name="location_id_generator",sequenceName="user_location_seq",allocationSize = 1)
     @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="location_id_generator")
	@Column(name="location_id")
	private Integer id; 
	@Column(name="latitude")
	private String lat;
	@Column(name="longitude")
	private String lon;
	
	public Location(String lat, String lon) {
		super();
		this.lat = lat;
		this.lon = lon;
	}
	
	public Location() {
		super();
	}

	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLon() {
		return lon;
	}
	public void setLon(String lon) {
		this.lon = lon;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	

}
