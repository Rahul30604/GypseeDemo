package com.GypseePvtLtd.GypseeDemo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GypseePvtLtd.GypseeDemo.Entity.Location;

public interface LocationJpaRepository extends JpaRepository<Location, Integer> {

}
