



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
	     String jndiName = "java:comp/env/jdbc/garage";
	     mysqlDS = (DataSource) context.lookup(jndiName);
	   }
	/*public void addStudent(Manufacturer s) throws SQLException {
		
		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("INSERT into students values(?,?,?)");
		myStmt.setInt(1, s.getId()); 
		myStmt.setString(2,s.getStudentName()); 
		myStmt.setString(3, s.getCourseID()); 
		// TODO Auto-generated method stub
		
	}*/
	
	public ArrayList<Manufacturer> getManufacturerDetails() throws Exception{
		ArrayList<Manufacturer> manufacturers = new ArrayList<>();
		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("SELECT * from manufacturer");
		
		ResultSet rs = myStmt.executeQuery();
		while(rs.next()){
			 String manu_code = rs.getString("manu_code");
			 String manu_name = rs.getString("manu_name");
			 String manu_details = rs.getString("manu_details");
			 
			 manufacturers.add(new Manufacturer(manu_code,manu_name, manu_details));
		}
		
		return manufacturers;
		
		
		
	}
	public ArrayList<Model> getModelDetails() throws Exception{
		ArrayList<Model> models = new ArrayList<>();
		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("SELECT * from model");
		
		ResultSet rs = myStmt.executeQuery();
		while(rs.next()){
			 String manu_code = rs.getString("manu_code");
			 String model_code = rs.getString("model_code");
			 String model_name = rs.getString("model_name");
			 
			 String model_desc = rs.getString("model_desc");
			 
			 models.add(new Model(manu_code, model_code, model_name, model_desc));
		}
		
		return models;
		
		
		
	}
	
	  }
