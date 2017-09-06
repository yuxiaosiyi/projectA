package org.lanqiao.entity;

import java.util.ArrayList;
import java.util.List;

public class PageInfo<T> {
	private int pagesize;
	private int pageindex;
	private int totalnumber;
	private List<T> datas=new ArrayList<T>();
	
	private int totalpages;
	private boolean isfirstpage;
	private boolean islastpage;
	
	
	
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getPageindex() {
		return pageindex;
	}
	public void setPageindex(int pageindex) {
		this.pageindex = pageindex;
	}
	public int getTotalnumber() {
		return totalnumber;
	}
	public void setTotalnumber(int totalnumber) {
		this.totalnumber = totalnumber;
	}
	public List<T> getDatas() {
		return datas;
	}
	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
	public int getTotalpages() {
		return totalpages;
	}
	public void setTotalpages(int totalpages) {
		this.totalpages = totalpages;
	}
	public boolean getIsfirstpage() {
		return isfirstpage;
	}
	public void setIsfirstpage(boolean isfirstpage) {
		this.isfirstpage = isfirstpage;
	}
	public boolean getIslastpage() {
		return islastpage;
	}
	public void setIslastpage(boolean islastpage) {
		this.islastpage = islastpage;
	}
}
