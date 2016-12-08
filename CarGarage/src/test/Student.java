package test;


import javax.faces.bean.ManagedBean;

@ManagedBean
public class Student {
	private int id;
	private String studentName;
	private String courseID;
	private String courseName;
	private String collegeName;
	private String county;
	
	
	public Student(){
		
	}
	
	public Student(int id, String studentName, String courseID, String courseName ,  String collegeName, String county) {
		super();
		this.id = id;
		this.studentName = studentName;
		this.courseID = courseID;
		this.courseName = courseName;
		this.collegeName = collegeName;
		this.county = county;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getCourseID() {
		return courseID;
	}
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public String getCounty() {
		return county;
	}
	public void setCountry(String country) {
		this.county = county;
	}
	
	

}

