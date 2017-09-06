package org.lanqiao.service;

import java.util.List;

import org.lanqiao.entity.User;

public interface UserService {
	
	public void getUser1(User user);
	public User login(String loginid,String password);
	public User getUserByLoginId(String loginid);
	public void updateUser(User user);
	public List<User> getuserOnback1();
	public void removeUser1(String userid);
}
