package com.GypseePvtLtd.GypseeDemo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GypseePvtLtd.GypseeDemo.Entity.User;

public interface UserJpaRepository extends JpaRepository<User,String>{

}
