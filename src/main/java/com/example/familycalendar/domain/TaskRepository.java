package com.example.familycalendar.domain;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {

	List<Task> findAll(Sort sort);

	List<Task> findByDescription(String description);

}
