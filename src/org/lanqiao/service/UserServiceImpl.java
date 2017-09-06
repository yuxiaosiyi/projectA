package org.lanqiao.service;

import java.util.List;

import org.lanqiao.dao.UserDao;
import org.lanqiao.dao.UserDaoImpl;
import org.lanqiao.entity.User;

public class UserServiceImpl implements UserService {
	private UserDao dao= new UserDaoImpl();
	@Override
	public void getUser1(User user) {
		dao.getUser(user);

	}
	@Override
	public User login(String loginid, String password) {
		User currentUser = dao.getUserByLoginId(loginid);
		User user = null;
		if(currentUser==null){//没有此账号;
			return null;
		}
		if(currentUser!=null){ //验证密码
			if(currentUser.getUpassword().equals(password)){
				user = currentUser;
				return user;
			}
		}
		
		return null;
	}
	@Override
	public User getUserByLoginId(String loginid) {
		// TODO Auto-generated method stub
		return dao.getUserByLoginId(loginid);
	}
	@Override
	public void updateUser(User user) {
		dao.upDate(user);;
		
	}
	@Override
	public List<User> getuserOnback1() {
		
		return dao.getuserOnback();
	}
	@Override
	public void removeUser1(String userid) {
		dao.removeUser(userid);
		
	}

}
