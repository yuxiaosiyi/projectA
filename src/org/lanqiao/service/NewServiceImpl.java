package org.lanqiao.service;

import java.util.List;

import org.lanqiao.dao.NewsDao;
import org.lanqiao.dao.NewsDaoImpl;
import org.lanqiao.entity.News;

public class NewServiceImpl implements NewsService {
	 NewsDao nd=new NewsDaoImpl();

	@Override
	public List<News> lista() {
		
		return nd.list();
	}

	@Override
	public News getNewsByid(String id) {
		News news1=nd.get(id);
		return news1;
	}

}
