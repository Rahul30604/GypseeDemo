package com.GypseePvtLtd.GypseeDemo.Entity;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="car")
public class Car {
	@Id
	@UuidGenerator
	@Column(name="car_id")
	private String carId;
	@NotNull
	@Column(name="user_id")
	private String userId;
	@Column(name="car_type")
	private String type;
	@Column(name="health")
	private Integer health;
	
	//constuctor
	public Car(@NotNull String userId, String type, Integer health) {
		super();
		this.userId = userId;
		this.type = type;
		this.health=health;
	}

	public Car() {
		super();
	}

	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getHealth() {
		return health;
	}

	public void setHealth(Integer health) {
		this.health = health;
	}
	
	
	

}
