package com.example.familycalendar.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface MonthRepository extends CrudRepository<Month, Long> {
	
	List<Month> findByName(String name);

}
