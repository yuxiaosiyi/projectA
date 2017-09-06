package org.lanqiao.service;

import org.lanqiao.dao.PasswordDao;
import org.lanqiao.dao.PasswordDaoImpl;
import org.lanqiao.entity.Passwordanswer;

public class PasswordServiceImpl implements PasswordService {
	private PasswordDao dao=new PasswordDaoImpl();
	@Override
	public void getPassword1(Passwordanswer password) {
		// TODO Auto-generated method stub
		dao.getPassword(password);

	}

}
