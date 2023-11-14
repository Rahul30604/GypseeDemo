package com.GypseePvtLtd.GypseeDemo.Service.UserService;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.GypseePvtLtd.GypseeDemo.DAO.UserJpaRepository;
import com.GypseePvtLtd.GypseeDemo.Entity.User;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	private UserJpaRepository repository;
	

	@Override
	public User getUser(String userId) {
		// TODO Auto-generated method stub
		return repository.getReferenceById(userId);
	  
	}

	@Override
	public User createUser(User user) {
		User usr=repository.save(user);
		return usr;
		// TODO Auto-generated method stub
		
	}

	@Override
	public User updateUser(User user, String userId) {
		User usr=repository.getReferenceById(userId);
		usr.setCity(user.getCity());
		usr.setDateOfBirth(user.getDateOfBirth());
		usr.setState(user.getState());
		usr.setName(user.getName());
		repository.save(usr);
		return usr;
		
		
	}

	@Override
	public void deleteUser(String userId) {
		// TODO Auto-generated method stub
	
		repository.deleteById(userId);
	}

}
