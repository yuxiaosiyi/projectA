package org.lanqiao.service;

import org.lanqiao.dao.GoodsDaoImpl;
import org.lanqiao.entity.Goods;
import org.lanqiao.entity.PageInfo;
import org.lanqiao.service.GoodsService;

public class GoodsServiceImpl implements GoodsService {
	private org.lanqiao.dao.GoodsDao dao = null;
	public GoodsServiceImpl() {
		dao = new GoodsDaoImpl();
	}
	@Override
	public PageInfo<Goods> goodsList(String cid, int pagesize, int pageindex) {
		return dao.list(cid, pagesize, pageindex);
	}
	@Override
	public Goods getGoodsBygid(String gid) {
		// TODO Auto-generated method stub
		return dao.get(gid);
	}
	@Override
	public void removeGoods1(String gid) {
		dao.removeGoods(gid);
		
	}
	@Override
	public void updateGoods(Goods goods) {
		dao.updateGoods(goods);
		
	}
	@Override
	public void addGoods(Goods goods) {
		dao.addGoods(goods);
		
	}

}
