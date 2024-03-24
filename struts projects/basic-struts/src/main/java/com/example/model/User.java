package com.example.model;

public class User {
	
	private int enrollmentId;
	private String name;
	private int age;
	private String gender;
	private String occupation;
	private String email;
	private String phoneNumber;
	private String city;
	private String state;
	
	private HealthHistory healthHistory;

	public User() {
		
	}

	public User(int enrollmentId, String name, int age, String gender, String occupation, String email,
			String phoneNumber, String city, String state, HealthHistory healthHistory) {
		super();
		this.enrollmentId = enrollmentId;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.occupation = occupation;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.city = city;
		this.state = state;
		this.healthHistory = healthHistory;
	}

	public int getEnrollment_id() {
		return enrollmentId;
	}

	public void setEnrollment_id(int enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public HealthHistory getHealthHistory() {
		return healthHistory;
	}

	public void setHealthHistory(HealthHistory healthHistory) {
		this.healthHistory = healthHistory;
	}

	@Override
	public String toString() {
		return "User [enrollmentId=" + enrollmentId + ", name=" + name + ", age=" + age + ", gender=" + gender
				+ ", occupation=" + occupation + ", email=" + email + ", phoneNumber=" + phoneNumber + ", city=" + city
				+ ", state=" + state + ", healthHistory=" + healthHistory + "]";
	}
	
	
	
	
	
}
