package com.spring.RestApi.srvices;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.RestApi.dao.CourseDao;
import com.spring.RestApi.entities.Course;
@Service
public class ServiceCourseImpl implements CourseSrevice{

	@Autowired
	private CourseDao objDao;
	
	//List<Course> list;
	
	public ServiceCourseImpl() {
		
//		list=new ArrayList<>();
//		list.add(new Course(123,"Java Core Course", "This is a beginner friendly course"));
//		list.add(new Course(125,"Spring boot course", "Creating project using Spring boot"));
		
	}
	@Override
	public List<Course> getCourses() {
		
		//return list;
		return objDao.findAll();
	}
	@SuppressWarnings("deprecation")
	@Override
	public Course getSingleCourse(long courseId) {
		
//		Course c=null;
//		for(Course co:list)
//		{
//			if(co.getId()==courseId);
//			c=co;
//			break;
//		}
		
		//return c;
		return objDao.getReferenceById(courseId); 
	}
	@Override
	public Course addSingleCourse(Course cors) {
		//list.add(cors);
		
		objDao.save(cors);
		return cors;
		
	}
	@Override
	public Course updateCourse(Course corse) {
		
//		list.forEach(e->{
//			if(e.getId()==corse.getId()) {
//				e.setTitle(corse.getTitle());
//		    e.setDescription(corse.getDescription());
//			}
//		});
		objDao.save(corse);
		return corse;
	}
	@Override
	public void deleteCourse(long parseLong) {
		//list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
		Course entity=objDao.getReferenceById(parseLong);
		objDao.delete(entity);
	}

}
