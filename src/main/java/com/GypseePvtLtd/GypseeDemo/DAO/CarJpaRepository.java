package com.GypseePvtLtd.GypseeDemo.DAO;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GypseePvtLtd.GypseeDemo.Entity.Car;

public interface CarJpaRepository extends JpaRepository<Car,String>{

	List<Car>findByUserId(String userId);

}
