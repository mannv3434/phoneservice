package com.iii.phonservice.model;

//-----------------User Model---------------------//
public class User {
	private String name;
	private String userName;
	private String email;
	private String pass;
	private String create_date;
	private String update_date;
	private String bio;
	private int sex;
	private String phonenumber;
	private String website;
	private String photo;
	private String location;
	
	/*----------Constructor-------------------*/
	public User() {
	}
	
	public User(String name, String userName, String email, String pass,
			String create_date, String update_date, String bio, int sex,
			String phonenumber, String website, String photo, String location) {
		super();
		this.name = name;
		this.userName = userName;
		this.email = email;
		this.pass = pass;
		this.create_date = create_date;
		this.update_date = update_date;
		this.bio = bio;
		this.sex = sex;
		this.phonenumber = phonenumber;
		this.website = website;
		this.photo = photo;
		this.location = location;
	}


	/*----------getter, setter-------------------*/
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}

	public String getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
