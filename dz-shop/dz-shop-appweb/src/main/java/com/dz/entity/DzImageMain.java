package com.dz.entity;

import java.util.Date;

public class DzImageMain {
	
	private int imgId;
	private String imgName;
	private String imgIndex;
	private String imgHight;
	private String imgWidth;
	private String imgUrl;
	private String author;
	private Date imgDatetime;
	private int imgCategory;
	private String stateflag;
	
	public int getImgId() {
		return imgId;
	}
	public void setImgId(int imgId) {
		this.imgId = imgId;
	}
	public String getImgName() {
		return imgName;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	public String getImgIndex() {
		return imgIndex;
	}
	public void setImgIndex(String imgIndex) {
		this.imgIndex = imgIndex;
	}
	public String getImgHight() {
		return imgHight;
	}
	public void setImgHight(String imgHight) {
		this.imgHight = imgHight;
	}
	public String getImgWidth() {
		return imgWidth;
	}
	public void setImgWidth(String imgWidth) {
		this.imgWidth = imgWidth;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getImgDatetime() {
		return imgDatetime;
	}
	public void setImgDatetime(Date imgDatetime) {
		this.imgDatetime = imgDatetime;
	}
	public int getImgCategory() {
		return imgCategory;
	}
	public void setImgCategory(int imgCategory) {
		this.imgCategory = imgCategory;
	}
	public String getStateflag() {
		return stateflag;
	}
	public void setStateflag(String stateflag) {
		this.stateflag = stateflag;
	}
	public DzImageMain(int imgId, String imgName, String imgIndex, String imgHight, String imgWidth, String imgUrl,
			String author, Date imgDatetime, int imgCategory, String stateflag) {
		super();
		this.imgId = imgId;
		this.imgName = imgName;
		this.imgIndex = imgIndex;
		this.imgHight = imgHight;
		this.imgWidth = imgWidth;
		this.imgUrl = imgUrl;
		this.author = author;
		this.imgDatetime = imgDatetime;
		this.imgCategory = imgCategory;
		this.stateflag = stateflag;
	}
	public DzImageMain() {
		super();
	}
	@Override
	public String toString() {
		return "DzImageMain [imgId=" + imgId + ", imgName=" + imgName + ", imgIndex=" + imgIndex + ", imgHight="
				+ imgHight + ", imgWidth=" + imgWidth + ", imgUrl=" + imgUrl + ", author=" + author + ", imgDatetime="
				+ imgDatetime + ", imgCategory=" + imgCategory + ", stateflag=" + stateflag + "]";
	}
	
	
	
	
}
