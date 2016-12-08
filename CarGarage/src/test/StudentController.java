package test;


import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class StudentController {
	private ArrayList<Student> students;
	private DAO dao;
	
	public StudentController(){
		try{
			dao = new DAO();
		} catch(Exception e){
			e.printStackTrace();
		}
		
	}
	public ArrayList<Student> getStudents(){
		return students;
	}
	
	
	public String addStudent(Student s) throws Exception{
		try{
			dao.addStudent(s);
			return "Added to DB";
		} catch (Exception e){
			return e.toString();
		}
		
	}
	
	public ArrayList<Student> loadStudents() throws Exception{
		return students = dao.getStudentDetails();
		
	}

}
