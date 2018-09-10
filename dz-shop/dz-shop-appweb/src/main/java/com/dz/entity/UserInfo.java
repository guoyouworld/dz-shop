package com.dz.entity;

import java.io.Serializable;

public class UserInfo implements Serializable{
    private static final long serialVersionUID = 1L;

    //
    private String avatarUrl;
    //
    private String city;
    //
    private Integer gender;
    //
    private String nickName;
    //
    private String province;

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

	@Override
	public String toString() {
		return "UserInfo [avatarUrl=" + avatarUrl + ", city=" + city + ", gender=" + gender + ", nickName=" + nickName
				+ ", province=" + province + "]";
	}

	public UserInfo(String avatarUrl, String city, Integer gender, String nickName, String province) {
		super();
		this.avatarUrl = avatarUrl;
		this.city = city;
		this.gender = gender;
		this.nickName = nickName;
		this.province = province;
	}

	public UserInfo() {
		super();
	}

    
}
