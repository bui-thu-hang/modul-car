package com.modul.model;

import com.google.protobuf.Timestamp;

public class UserModel {
	private int userID;
	private String fullname;
	private String idCard;
	private String email;
	private String phone;
	private String addrest;
	private Timestamp birthDay;
	private String username;
	private String password;
	private String role;
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddrest() {
		return addrest;
	}
	public void setAddrest(String addrest) {
		this.addrest = addrest;
	}
	public Timestamp getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Timestamp birthDay) {
		this.birthDay = birthDay;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	

}
