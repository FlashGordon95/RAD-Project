


import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO {
	private DataSource mysqlDS;
	public DAO() throws Exception {
	     Context context = new InitialContext();
	     String jndiName = "java:comp/env/jdbc/studentdb3";
	     mysqlDS = (DataSource) context.lookup(jndiName);
	   }
	public void addStudent(Student s) throws SQLException {
		
		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("INSERT into students values(?,?,?)");
		myStmt.setInt(1, s.getId()); 
		myStmt.setString(2,s.getStudentName()); 
		myStmt.setString(3, s.getCourseID()); 
		// TODO Auto-generated method stub
		
	}
	
	public ArrayList<Student> getStudentDetails() throws Exception{
		ArrayList<Student> students = new ArrayList<>();
		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("SELECT * from student_table s JOIN course_table c ON s.course_id = c.course_id  JOIN college_table e ON c.college_id = e.college_id");
		
		ResultSet rs = myStmt.executeQuery();
		while(rs.next()){
			 int id = rs.getInt("student_id");
			 String studentName = rs.getString("student_name");
			 String courseID = rs.getString("course_id");
			 String courseName = rs.getString("course_name");
			 String collegeName = rs.getString("college_name");
			 String county = rs.getString("county");
			 
			 students.add(new Student(id,studentName,courseID, courseName, collegeName,county));
		}
		
		return students;
		
		
		
	}
	
	  }
