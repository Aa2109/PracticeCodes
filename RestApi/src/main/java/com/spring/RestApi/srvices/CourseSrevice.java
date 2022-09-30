package com.spring.RestApi.srvices;
import java.util.*;

import com.spring.RestApi.entities.Course;
public interface CourseSrevice {

	public List<Course> getCourses();
	public Course getSingleCourse(long courseId);
	public Course addSingleCourse(Course cors);
	public Course updateCourse(Course corse);
	public void  deleteCourse(long parseLong);
}
