package com.model;

public class User implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1581931210113859198L;
	private String id;
	private String password;
	private String name;
	private String address;
	private String phoneNum;
	private String email;
	private int age;
	
	//생성자
	public User() {}
	
	
	//매개변수 있는 생성자
	public User(String id,String password,String name, String address, String phoneNum, String email,int age) {
		this.id = id;
		this.password = password;
		this.name =name;
		this.address = address;
		this.phoneNum = phoneNum;
		this.email = email;
		this.age = age;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", name=" + name + ", address=" + address + ", phoneNum="
				+ phoneNum + ", email=" + email + ", age=" + age + "]";
	}
	
	
}
