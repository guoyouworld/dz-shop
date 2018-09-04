package com.dz.entity;

public class DzImageCategory {
	
	private int int_id;
	private String category_name;
	private String category_info;
	private String author;
	private String category_datetime;
	private String stateflag;
	
	public int getInt_id() {
		return int_id;
	}
	public void setInt_id(int int_id) {
		this.int_id = int_id;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public String getCategory_info() {
		return category_info;
	}
	public void setCategory_info(String category_info) {
		this.category_info = category_info;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCategory_datetime() {
		return category_datetime;
	}
	public void setCategory_datetime(String category_datetime) {
		this.category_datetime = category_datetime;
	}
	public String getStateflag() {
		return stateflag;
	}
	public void setStateflag(String stateflag) {
		this.stateflag = stateflag;
	}
	public DzImageCategory(int int_id, String category_name, String category_info, String author,
			String category_datetime, String stateflag) {
		super();
		this.int_id = int_id;
		this.category_name = category_name;
		this.category_info = category_info;
		this.author = author;
		this.category_datetime = category_datetime;
		this.stateflag = stateflag;
	}
	public DzImageCategory() {
		super();
	}
	@Override
	public String toString() {
		return "DzImageCategory [int_id=" + int_id + ", category_name=" + category_name + ", category_info="
				+ category_info + ", author=" + author + ", category_datetime=" + category_datetime + ", stateflag="
				+ stateflag + "]";
	}
	
	
}
