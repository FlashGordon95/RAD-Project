



import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.context.FacesContext;
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
	public void addManufacturer(Manufacturer s) throws SQLException {
		
		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("INSERT into manufacturer values(?,?,?)");
		myStmt.setString(1, s.getManu_code()); 
		myStmt.setString(2,s.getManu_name()); 
		myStmt.setString(3, s.getManu_details()); 
		// TODO Auto-generated method stub
		
		myStmt.executeUpdate();
		
	}
	
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
	
	public ArrayList<Vehicle> getVehicleDetails() throws Exception{
		ArrayList<Vehicle> vehicles = new ArrayList<>();
		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("SELECT * from vehicle");
		
		ResultSet rs = myStmt.executeQuery();
		while(rs.next()){
			 String reg = rs.getString("reg");
			 String manu_code = rs.getString("manu_code");
			 String model_code = rs.getString("model_code");
			 
			 int mileage = rs.getInt("mileage");
			 double price = rs.getDouble("price");
			 String colour = rs.getString("colour");
			 String fuel = rs.getString("fuel");
			 
			 vehicles.add(new Vehicle( reg,  manu_code,  model_code,  mileage,  price,  colour,
						 fuel));
		}
		
		return vehicles;
		
		
		
	}
	
	  }
