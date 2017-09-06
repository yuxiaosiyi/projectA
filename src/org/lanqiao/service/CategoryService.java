package org.lanqiao.service;

import java.util.List;

import org.lanqiao.entity.Category;

public interface CategoryService {
	
		public List<Category> getCategory1();
		public Category getCategoryById(String cid);
}
