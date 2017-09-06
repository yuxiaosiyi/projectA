package org.lanqiao.dao;

import org.lanqiao.entity.Goods;
import org.lanqiao.entity.PageInfo;

public interface GoodsDao {
	public PageInfo<Goods> list(String cid,int pagesize ,int pageindex);
	public int totalRecords(String cid);
	public Goods get(String id); 
	public void addGoods(Goods goods);
	public void updateGoods(Goods goods);
	public void removeGoods(String gid);
}
