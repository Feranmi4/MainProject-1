package com.aptech.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aptech.org.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Integer> {

}
