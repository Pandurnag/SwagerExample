package com.swager.example.service;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.swager.example.dao.StudentDAO;

@Service
public class StudentService {
	
	
	static Map<Integer,StudentDAO> mymap;
	
	private final static Logger logger=LoggerFactory.getLogger(StudentService.class);
	
	//StudentDAO dao=new StudentDAO(studentid, studentname, studentphone);
	
	/*DATA*/
	public static Map<Integer, StudentDAO> StudentDetails() {
		
		logger.info("--studentDetails()--{}");
		mymap=new ConcurrentHashMap<Integer, StudentDAO>();
		
		mymap.put(1,new StudentDAO(100, "JON", 111));
		mymap.put(2,new StudentDAO(200, "JAX", 222));
		mymap.put(3,new StudentDAO(300, "ANN", 333));
		mymap.put(4,new StudentDAO(400, "OM", 444));
		
		return mymap;
		
	}
	
	/*GET the Student Details*/
	public static Map<Integer, StudentDAO> getstudentDetailsbyId(int id) {
	
		logger.info("--Student Details by ID() --id {} " +id);
		
		Map<Integer, StudentDAO> studentData = StudentDetails();
		
		return studentData;
		
	}
	/*GET the Student Details by ID*/
	public static List<Entry<Integer, StudentDAO>> createStudentDetailsbyID(int id) {
		
		Map<Integer, StudentDAO> studentData = StudentDetails();
		
			
			List<Entry<Integer, StudentDAO>> studentbyid = studentData.entrySet().stream().filter(x->x.getKey()==id)
					.collect(Collectors.toList());
			
			logger.info("--getStudentDetailsbyId() -- RSSPONSE {} " +studentbyid);
			return studentbyid;
	}
	
	/*PUT the Student Details by ID*/
	public static Map<Integer, StudentDAO> createStudentDetails(int id,StudentDAO dao ) {
		
		logger.info("--createStudentDetails() -- {} " + "id" + id + "DAO" +dao);
		
		Map<Integer, StudentDAO> studentData = StudentDetails();
		
		if(!studentData.containsKey(id)) {
			
			
			mymap.put(id, new StudentDAO(dao.getStudentid(), dao.getStudentname(), dao.getStudentphone()));
			
		}else {
			
			logger.error("--createStudentDetails() -- Key Duplicate");
			
		}
		logger.info("--createStudentDetails() -- RESPONSE {} "+mymap);
		return mymap;
		
	}
	/*POST the Student Details by ID*/
	public static Map<Integer, StudentDAO>  updateStudentDetails(int id,StudentDAO dao) {
		
		logger.info("--updateStudentDetails() -- id {} "+id +"DAO" + dao);
		Map<Integer, StudentDAO> studentData = StudentDetails();
		
		if(studentData.containsKey(id)) {
		 
			mymap.put(id, new StudentDAO(dao.getStudentid(), dao.getStudentname(), dao.getStudentphone()));
			 
		}else {
			
			logger.error("--createStudentDetails() -- Key not abalable ");
			
		}
		logger.info("--updateStudentDetails() -- RESPONSE {} "+mymap);
		return mymap;
	}
	
	/*DELETE the Student Details by ID*/
	public static Map<Integer, StudentDAO> deleteStudentDetails(int id) {
		logger.info("--deleteStudentDetails() -- {}"  +id  );
		Map<Integer, StudentDAO> studentData = StudentDetails();
		
		if(studentData.containsKey(id)) {
			
			mymap.remove(id);
			
		}else {
			logger.error("--createStudentDetails() -- Key not abalable ");
		}
		logger.info("--deleteStudentDetails() -- RESPONSE {}"  +mymap );
		return mymap;
		
	}

	public Map<Integer, StudentDAO> getStudentDetails() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
