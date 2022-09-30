package com.spring.RestApi.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.RestApi.entities.Course;
import com.spring.RestApi.srvices.CourseSrevice;

import java.util.*;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class MyController {

	@Autowired
	private CourseSrevice obj;
	
	//get the course
	@GetMapping("/getAllCourse") 
	public List<Course> getCourses(){
		return this.obj.getCourses();
	}
	
	
	//get single course
	@GetMapping("/getsingleCourse/{courseId}")
	public Course getSingleCourse(@PathVariable String courseId) {
		return this.obj.getSingleCourse(Long.parseLong(courseId));
	}
	
	//add course
	@PostMapping("/addOneMoreCourse")
	public Course addCourse(@RequestBody Course cors) {
		return this.obj.addSingleCourse(cors);
	}
	
	// update course
	@PutMapping("/updatecourse")
	public Course updatecourse(@RequestBody Course corse) {
		return this.obj.updateCourse(corse);
	}
	
	// Delete course
	@DeleteMapping("/DeleteCourse/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
		try {
			this.obj.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
