package com.dz.entity;

import java.util.Date;

public class DzImageHost {
	private int hostId;
	private String hostName;
	private String hostUrl;
	private String author;
	private Date hostDatetime;
	private String stateflag;
	public int getHostId() {
		return hostId;
	}
	public void setHostId(int hostId) {
		this.hostId = hostId;
	}
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public String getHostUrl() {
		return hostUrl;
	}
	public void setHostUrl(String hostUrl) {
		this.hostUrl = hostUrl;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getHostDatetime() {
		return hostDatetime;
	}
	public void setHostDatetime(Date hostDatetime) {
		this.hostDatetime = hostDatetime;
	}
	public String getStateflag() {
		return stateflag;
	}
	public void setStateflag(String stateflag) {
		this.stateflag = stateflag;
	}
	public DzImageHost(int hostId, String hostName, String hostUrl, String author, Date hostDatetime,
			String stateflag) {
		super();
		this.hostId = hostId;
		this.hostName = hostName;
		this.hostUrl = hostUrl;
		this.author = author;
		this.hostDatetime = hostDatetime;
		this.stateflag = stateflag;
	}
	public DzImageHost() {
		super();
	}
	@Override
	public String toString() {
		return "DzImageHost [hostId=" + hostId + ", hostName=" + hostName + ", hostUrl=" + hostUrl + ", author="
				+ author + ", hostDatetime=" + hostDatetime + ", stateflag=" + stateflag + "]";
	}
	
}
