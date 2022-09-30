package com.spring.RestApi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.RestApi.entities.Course;

public interface CourseDao extends JpaRepository<Course, Long>
{

}