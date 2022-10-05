package com.aptech.org;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.aptech.org.entity.Country;
import com.aptech.org.repository.CountryRepository;
import com.aptech.org.service.CountryService;

@SpringBootTest(classes= {ServiceMackitoTests.class})
public class ServiceMackitoTests {

@Mock
CountryRepository  countryRepository;

@InjectMocks
CountryService countryService;

@Test
@Order(1)
public void test_getAllCountries() {
	List<Country> myCountries = new ArrayList<Country>();
	myCountries.add(new Country(1, "Korea", "Seoul"));
	myCountries.add(new Country(2, "Netherlands", "Amsterdam"));
	
	when(countryRepository.findAll()).thenReturn(myCountries);
	assertEquals(2, countryService.getCountries().size());
}

@Test
@Order(2)
public void test_getCountryById() {
	List<Country> myCountries = new ArrayList<Country>();
	myCountries.add(new Country(1, "Korea", "Seoul"));
	myCountries.add(new Country(2, "Netherlands", "Amsterdam"));
	int countryID=1;
	
	when(countryRepository.findAll()).thenReturn(myCountries);
	assertEquals(countryID, countryService.getCountryById(countryID).getId());
}


@Test
@Order(3)
public void test_getCountryByName() {
	List<Country> myCountries = new ArrayList<Country>();
	myCountries.add(new Country(1, "Korea", "Seoul"));
	myCountries.add(new Country(2, "Netherlands", "Amsterdam"));
	String countryName="Korea";
	
	when(countryRepository.findAll()).thenReturn(myCountries);
	assertEquals(countryName, countryService.getCountryByName(countryName).getCountryName());
}

@Test
@Order(4)
public void test_getCountryByCapital() {
	List<Country> myCountries = new ArrayList<Country>();
	myCountries.add(new Country(1, "Korea", "Seoul"));
	myCountries.add(new Country(2, "Netherlands", "Amsterdam"));
	String countryCapital="Seoul";
	
	when(countryRepository.findAll()).thenReturn(myCountries);
	assertEquals(countryCapital, countryService.getCountryByCapital(countryCapital).getCountryCapital());
}


@Test
@Order(5)
public void test_addCountry() {
	Country country = new Country(3, "Germany", "Berlin");
	
	
	when(countryRepository.save(country)).thenReturn(country);
	assertEquals(country, countryService.addCountry(country));
}

@Test
@Order(6)
public void test_updateCountry() {
	Country country = new Country(3, "Germany", "Berlin");
	
	
	when(countryRepository.save(country)).thenReturn(country);
	assertEquals(country, countryService.updateCountry(country));
}

@Test
@Order(7)
public void test_deleteCountry() {
	Country country = new Country(3, "Germany", "Berlin");
	
	countryService.deleteCountry(country);

	verify(countryRepository, times(1)).delete(country);
}

}
