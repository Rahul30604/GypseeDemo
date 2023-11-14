package com.GypseePvtLtd.GypseeDemo.Service.UserService;

import com.GypseePvtLtd.GypseeDemo.Entity.User;

public interface UserService {
	public User getUser(String userId);
	public User createUser(User user);
	public User updateUser(User user,String userId);
	public void deleteUser(String userId);
	//User updateUser(User user, String userId);
	

}
