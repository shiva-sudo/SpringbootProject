package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.binding.Course;
import com.example.demo.repo.CourseRepository;


@Service
public class CourseServiceImpl implements CourseService{
	@Autowired
	private CourseRepository courseRepo;
	@Override
	
	//upsert : its a insert/update based on PK
	
	public String upsert(Course course) {
		courseRepo.save(course);
		
		return "Success";
	}

	@Override
	public Course getById(Integer cid) {
		Optional<Course> findbyid = courseRepo.findById(cid);
		if(findbyid.isPresent()) {
			return findbyid.get();
		}
		return null;
	}

	@Override
	public List<Course> getAllCoourse() {
		 
		return courseRepo.findAll();
	}

	@Override
	public String deleteById(Integer cid) {
		if (courseRepo.existsById(cid)) {
			courseRepo.deleteById(cid);
			return "Record Deleted successfully";
		}
		else {
			return "No Record Found";
		}
	}

}
