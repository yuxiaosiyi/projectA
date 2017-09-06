package org.lanqiao.dao;

import java.util.List;

import org.lanqiao.entity.User;

public interface UserDao {
	public void getUser(User user);
	public User getUserByLoginId(String loginid);
	public void upDate(User user);
	public List<User> getuserOnback();
	public void removeUser(String userid);
}
