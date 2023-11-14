package com.GypseePvtLtd.GypseeDemo.Entity;

import java.time.LocalDate;


import org.hibernate.annotations.UuidGenerator;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity(name="User")
public class User {
	
	
	//attributes in user
	@Id()
//	@SequenceGenerator(name="id_generator",sequenceName="user_id_seq",allocationSize = 1)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="id_generator")
	@UuidGenerator
	@Column(name="user_Id")
	private  String userId;
	@Size(min=2,message="Name should have atleast 2 characters")
	@Column(name="user_Name")
	private String name;
	@Past(message="Date of Birth should be in Past")
	@Column(name="date_Of_Birth")
	private LocalDate dateOfBirth;
	@NotNull
	@Size(min=2)
	@Column(name="user_City")
	private String city;
	@Size(min=2)
	@Column(name="user_State")
	private String state;
	@Column(name="points")
	private Integer points=0;
	
	//constructor
	
	public User(String name, LocalDate dateOfBirth, String city, String state) {
		super();
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.city = city;
		this.state = state;
		this.points=0;
	}

	public User() {
		super();
	}

	//getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}


	public int getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	
	
	
	
	
	
	
	
	

}
