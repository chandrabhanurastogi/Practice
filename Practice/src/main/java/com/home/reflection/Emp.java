package com.home.reflection;

public class Emp {

	private String name;
	private String add;
	private String hobby;
	private int dob;
	private boolean gender;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public int getDob() {
		return dob;
	}
	public void setDob(int dob) {
		this.dob = dob;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public Emp(String name, String add, String hobby, int dob, boolean gender) {
		super();
		this.name = name;
		this.add = add;
		this.hobby = hobby;
		this.dob = dob;
		this.gender = gender;
	}
	
	public Emp(){
		
	}
	


}
