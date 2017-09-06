package org.lanqiao.entity;

public class News {
	private String TID;
	private String TITLE;
	private String TCONTENT;
	private String TPUBDATE;
	public String getTID() {
		return TID;
	}
	public void setTID(String tID) {
		TID = tID;
	}
	public String getTITLE() {
		return TITLE;
	}
	public void setTITLE(String tITLE) {
		TITLE = tITLE;
	}
	public String getTCONTENT() {
		return TCONTENT;
	}
	public void setTCONTENT(String tCONTENT) {
		TCONTENT = tCONTENT;
	}
	public String getTPUBDATE() {
		return TPUBDATE;
	}
	public void setTPUBDATE(String tPUBDATE) {
		TPUBDATE = tPUBDATE;
	}
	public News(String tID, String tITLE, String tCONTENT, String tPUBDATE) {
		super();
		TID = tID;
		TITLE = tITLE;
		TCONTENT = tCONTENT;
		TPUBDATE = tPUBDATE;
	}
	public News(){}
	

}
