


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean
public class Manufacturer {
	private String manu_code;
	private String manu_name;
	private String manu_details;
	
	public Manufacturer(){
		
	}
	
	public Manufacturer( String studentName, String courseID, String courseName) {
		super();
		this.manu_code = studentName;
		this.manu_name = courseID;
		this.manu_details = courseName;
	}

	public String getManu_code() {
		return manu_code;
	}

	public void setManu_code(String manu_code) {
		this.manu_code = manu_code;
	}

	public String getManu_name() {
		return manu_name;
	}

	public void setManu_name(String manu_name) {
		this.manu_name = manu_name;
	}

	public String getManu_details() {
		return manu_details;
	}

	public void setManu_details(String manu_details) {
		this.manu_details = manu_details;
	}
	
	

}

