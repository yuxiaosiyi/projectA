package org.lanqiao.dao;

import java.util.List;

import org.lanqiao.entity.Category;

public interface CategoryDao {
	public List<Category> getCategory();
	public Category get(String cid);
}
