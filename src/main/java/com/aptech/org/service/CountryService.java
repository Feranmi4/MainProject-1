package com.aptech.org.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.aptech.org.entity.Country;
import com.aptech.org.repository.CountryRepository;

@Component
@Service
public class CountryService {
	
	CountryRepository countryRepository;
	
	
	@Autowired
	public CountryService(CountryRepository countryRepository) {
		super();
		this.countryRepository = countryRepository;
	}
	
	public List getCountries(){
		List<Country> countries = countryRepository.findAll();
		return countries;
	}
	
	public Country getCountryById(int id) {
	  List<Country> countries = countryRepository.findAll();
	  Country country = null;
	  for(Country con : countries) {
		  if(con.getId()==id) {
			  country = con;
		  }
	  }
	  return country;
	}
	
	
	public Country getCountryByName(String countryName) {
	List<Country> countries = countryRepository.findAll();
	Country con = null;
	for(Country country : countries) {
		if(country.getCountryName().equalsIgnoreCase(countryName)) {
			con = country;
		}
	}
	return con;
	}
	
	public Country getCountryByCapital(String countryCapital) {
		List<Country> countries = countryRepository.findAll();
		Country con = null;
		for(Country cap : countries) {
			if(cap.getCountryCapital().equalsIgnoreCase(countryCapital)) {
				con = cap;
			}
		}
		return con;
		}
	
	
	public Country addCountry(Country country) {
		country.setId(maxId());
		countryRepository.save(country);
		return country;
	}
	
	public int maxId() {
	  return countryRepository.findAll().size() + 1;	
	}
	
	public Country updateCountry(Country country) {
		countryRepository.save(country);
		return country;
	}
	
	public void deleteCountry(Country country) {
		countryRepository.delete(country);
	}
	
	
	

	
	
}
