package com.aptech.org.entity;

import javax.persistence.*;

@Entity
@Table(name="country")
public class Country {
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="country_name")
	private String countryName;
	
	@Column(name="country_capital")
	private String countryCapital;
	
	public Country() {}

	
	public Country(int id, String countryName, String countryCapital) {
		super();
		this.id = id;
		this.countryName = countryName;
		this.countryCapital = countryCapital;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCountryName() {
		return countryName;
	}
	
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
	public String getCountryCapital() {
		return countryCapital;
	}
	
	public void setCountryCapital(String countryCapital) {
		this.countryCapital = countryCapital;
	}
	
	@Override
	public String toString() {
		return "Country [id=" + id + ", countryName=" + countryName + ", countryCapital=" + countryCapital + "]";
	}
	
	
	

}
