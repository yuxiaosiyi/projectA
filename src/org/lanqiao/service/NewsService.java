package org.lanqiao.service;

import java.util.List;

import org.lanqiao.entity.News;

public interface NewsService {
	 public List<News> lista();
	 public News getNewsByid(String id);
}
