package com.GypseePvtLtd.GypseeDemo.Service.LocationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.GypseePvtLtd.GypseeDemo.DAO.LocationJpaRepository;
import com.GypseePvtLtd.GypseeDemo.Entity.Location;

@Component
public class LocationService {
	@Autowired
	LocationJpaRepository repository;
	public Integer createLocation(String lat,String lon) {
		Location presentLocation=repository.save(new Location(lat,lon));
		return presentLocation.getId();
	}

}
