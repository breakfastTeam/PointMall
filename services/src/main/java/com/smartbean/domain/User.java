package com.smartbean.domain;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
@Table(name="t_user")
public class User {

  private long id;
  private String username;
  private String password;
  private long gender;
  private long birthday;
  private long registerTime;
  private long lastLoginTime;
  private String lastLoginIp;
  private long userLevelId;
  private String nickname;
  private String mobile;
  private String registerIp;
  private String avatar;
  private String weixinOpenid;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public long getGender() {
    return gender;
  }

  public void setGender(long gender) {
    this.gender = gender;
  }


  public long getBirthday() {
    return birthday;
  }

  public void setBirthday(long birthday) {
    this.birthday = birthday;
  }


  public long getRegisterTime() {
    return registerTime;
  }

  public void setRegisterTime(long registerTime) {
    this.registerTime = registerTime;
  }


  public long getLastLoginTime() {
    return lastLoginTime;
  }

  public void setLastLoginTime(long lastLoginTime) {
    this.lastLoginTime = lastLoginTime;
  }


  public String getLastLoginIp() {
    return lastLoginIp;
  }

  public void setLastLoginIp(String lastLoginIp) {
    this.lastLoginIp = lastLoginIp;
  }


  public long getUserLevelId() {
    return userLevelId;
  }

  public void setUserLevelId(long userLevelId) {
    this.userLevelId = userLevelId;
  }


  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }


  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }


  public String getRegisterIp() {
    return registerIp;
  }

  public void setRegisterIp(String registerIp) {
    this.registerIp = registerIp;
  }


  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }


  public String getWeixinOpenid() {
    return weixinOpenid;
  }

  public void setWeixinOpenid(String weixinOpenid) {
    this.weixinOpenid = weixinOpenid;
  }

}
