package com.swager.example.controller;

import java.util.List;
import java.util.Map;
/*
 * localhost
 * */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.swager.example.dao.StudentDAO;
import com.swager.example.service.StudentService;
import com.swager.example.to.Student;

@RestController
public class StudentController {
	
	private final static Logger logger=LoggerFactory.getLogger(StudentService.class);
	
	@Autowired
	StudentService service;
	
	@GetMapping("/studentsdetails")
	public Map<Integer, StudentDAO> getMyStudentsDetails() {
		logger.info("--getMyStudentsDetails()--{}");
		return service.getStudentDetails();
		
	}
    @GetMapping("/studentsdetailsbyid/{id}")
	public Map<Integer, StudentDAO> getMyStudentsDetailsbyID(@PathVariable int id) {
    	logger.info("--getMyStudentsDetailsbyID()--{}");
		return service.getstudentDetailsbyId(id);
	}
    
    @PostMapping("/updatestudentsdetailsbyid/{id}")
	public Map<Integer, StudentDAO> updatetMyStudentsDetailsbyID(@PathVariable int id , @RequestBody Student to) {
    	
    	StudentDAO dao=new StudentDAO();
    	dao.setStudentid(to.getStudentid());
    	dao.setStudentname(to.getStudentname());
    	dao.setStudentphone(to.getStudentphone());
    	
    	Map<Integer, StudentDAO> updatestudentdetails = service.updateStudentDetails(id, dao);
    	logger.info("--updatetMyStudentsDetails()--{}"+updatestudentdetails);
    	return updatestudentdetails;
		
	}
    
    @PutMapping("/createstudentsdetailsbyid/{id}")
	public Map<Integer, StudentDAO> createMyStudentsDetailsbyID(@PathVariable int id , @RequestBody Student to) {
    	
    	StudentDAO dao=new StudentDAO();
    	dao.setStudentid(to.getStudentid());
    	dao.setStudentname(to.getStudentname());
    	dao.setStudentphone(to.getStudentphone());
    	
    	Map<Integer, StudentDAO> newstudentdata = service.createStudentDetails(id, dao);
    	logger.info("--createMyStudentsDetailsbyID()--{}"+newstudentdata);
    	return newstudentdata;
		
	}
    @DeleteMapping("/deletestudentsdetailsbyid/{id}")
	public Map<Integer, StudentDAO> deleteMyStudentsDetailsbyID(@PathVariable int id ) {
    	Map<Integer, StudentDAO> afterdeleting = service.deleteStudentDetails(id);
    	logger.info("--deleteMyStudentsDetailsbyID()--{}"+afterdeleting);
    	return afterdeleting;
		
	}
}
