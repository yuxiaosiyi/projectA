package org.lanqiao.service;

import java.util.List;

import org.lanqiao.dao.CategoryDao;
import org.lanqiao.dao.CategoryDaoImpl;
import org.lanqiao.entity.Category;

public class CategoryServiceImpl implements CategoryService {
	private CategoryDao cd=new CategoryDaoImpl();
	@Override
	public List<Category> getCategory1() {
		
		return cd.getCategory();
	}
	@Override
	public Category getCategoryById(String cid) {
		// TODO Auto-generated method stub
		return cd.get(cid);
	}

}
