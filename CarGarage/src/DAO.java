
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@ManagedBean
@SessionScoped
public class DAO {

	private DataSource mysqlDS;

	public DAO() throws Exception {
		Context context = new InitialContext();
		String jndiName = "java:comp/env/jdbc/garage";
		mysqlDS = (DataSource) context.lookup(jndiName);
	}

	public void addManufacturer(Manufacturer s) throws SQLException {

		Connection conn = mysqlDS.getConnection(); // set up connection
		PreparedStatement myStmt = conn.prepareStatement("INSERT into manufacturer values(?,?,?)"); // prepare
																									// statment
		myStmt.setString(1, s.getManu_code());
		myStmt.setString(2, s.getManu_name());
		myStmt.setString(3, s.getManu_details()); // add parameters to statement
		// TODO Auto-generated method stub

		myStmt.executeUpdate(); // runn statement

		conn.close();
		myStmt.close(); // close connections for good manners

	}

	public void addModel(Model s) throws SQLException {

		Connection conn = mysqlDS.getConnection(); // set up connection
		PreparedStatement myStmt = conn.prepareStatement("INSERT into model values(?,?,?,?)"); // prepare
																								// statement
		myStmt.setString(1, s.getManu_code());
		myStmt.setString(2, s.getModel_code());
		myStmt.setString(3, s.getModel_name());
		myStmt.setString(4, s.getModel_desc());
		// TODO Auto-generated method stub

		myStmt.executeUpdate(); // run statement

		conn.close();
		myStmt.close(); // close connections for good manners

	}

	public void addVehicle(Vehicle s) throws SQLException {

		Connection conn = mysqlDS.getConnection(); // set up connection
		PreparedStatement myStmt = conn.prepareStatement("INSERT into vehicle values(?,?,?,?,?,?,?)"); // prepare
																										// statement
		myStmt.setString(1, s.getReg());
		myStmt.setString(2, s.getManu_code());
		myStmt.setString(3, s.getModel_code());
		myStmt.setInt(4, s.getMileage());
		myStmt.setDouble(5, s.getPrice());
		myStmt.setString(6, s.getColour());
		myStmt.setString(7, s.getFuel());
		// May want to change this to enum , will need to change vehicle.java
		// attribute to enum also
		// TODO Auto-generated method stub

		myStmt.executeUpdate(); // run statement

		conn.close();
		myStmt.close(); // close connections for good manners
	}

	public ArrayList<Manufacturer> getManufacturerDetails() throws Exception {
		ArrayList<Manufacturer> manufacturers = new ArrayList<>();
		Connection conn = mysqlDS.getConnection(); // set up connection
		PreparedStatement myStmt = conn.prepareStatement("SELECT * from manufacturer");

		ResultSet rs = myStmt.executeQuery();
		// while rs has another Result run loop and add to ArrayList
		while (rs.next()) {
			String manu_code = rs.getString("manu_code");
			String manu_name = rs.getString("manu_name");
			String manu_details = rs.getString("manu_details");

			manufacturers.add(new Manufacturer(manu_code, manu_name, manu_details));
		}
		conn.close();
		myStmt.close(); // close connections for good manners
		return manufacturers;
	}

	public ArrayList<Model> getModelDetails() throws Exception {
		ArrayList<Model> models = new ArrayList<>();
		Connection conn = mysqlDS.getConnection(); // set up connection
		PreparedStatement myStmt = conn.prepareStatement("SELECT * from model");

		ResultSet rs = myStmt.executeQuery();
		// while rs has another Result run loop and add to ArrayList
		while (rs.next()) {
			String manu_code = rs.getString("manu_code");
			String model_code = rs.getString("model_code");
			String model_name = rs.getString("model_name");

			String model_desc = rs.getString("model_desc");

			models.add(new Model(manu_code, model_code, model_name, model_desc));
		}
		conn.close();
		myStmt.close(); // close connections for good manners
		return models;

	}

	public ArrayList<Vehicle> getVehicleDetails() throws Exception {
		ArrayList<Vehicle> vehicles = new ArrayList<>();
		Connection conn = mysqlDS.getConnection(); // set up connection
		PreparedStatement myStmt = conn.prepareStatement("SELECT * from vehicle");

		ResultSet rs = myStmt.executeQuery();
		// while rs has another Result run loop and add to ArrayList
		while (rs.next()) {
			String reg = rs.getString("reg");
			String manu_code = rs.getString("manu_code");
			String model_code = rs.getString("model_code");

			int mileage = rs.getInt("mileage");
			double price = rs.getDouble("price");
			String colour = rs.getString("colour");
			String fuel = rs.getString("fuel");

			vehicles.add(new Vehicle(reg, manu_code, model_code, mileage, price, colour, fuel));
		}
		conn.close();
		myStmt.close(); // close connections for good manners
		return vehicles;

	}

	public ArrayList<Vehicle> getSpecificVehicleDetails(String v) throws SQLException {

		ArrayList<Vehicle> vehicle = new ArrayList<>();
		Connection conn = mysqlDS.getConnection(); // set up connection
		String reg = v;
		String formattedStmt = "select * from vehicle where reg =" + reg;
		PreparedStatement myStmt = conn.prepareStatement(formattedStmt);

		ResultSet result = myStmt.executeQuery();
		// while result has another Result run loop and add to ArrayList
		while (result.next()) {
			reg = result.getString("reg");
			String manu_code = result.getString("manu_code");
			String model_code = result.getString("model_code");
			int mileage = result.getInt("mileage");
			float price = result.getFloat("price");
			String colour = result.getString("colour");
			String fuel = result.getString("fuel");

			vehicle.add(new Vehicle(reg, manu_code, model_code, mileage, price, colour, fuel));
		}

		conn.close();
		myStmt.close(); // close connections for good manners

		return vehicle;

	} // end getVehicle

	public void updateManufacturer(Manufacturer manufacturer) throws SQLException {

		Connection conn = mysqlDS.getConnection(); // set up connection
		PreparedStatement myStmt = conn.prepareStatement(
				"Update manufacturer" + " Set manu_name = ?," + " manu_details = ?" + " where manu_code = ?"); // preapre
																												// statement

		myStmt.setString(1, manufacturer.getManu_name());
		myStmt.setString(2, manufacturer.getManu_details());
		myStmt.setString(3, manufacturer.getManu_code());
		// add parameters to statement

		myStmt.executeUpdate(); // execute statement

		conn.close();
		myStmt.close(); // close connections for good manners
	}

	// Delete a Manufacturer of cars
	public void delete(Manufacturer m) throws SQLException {
		System.out.print("Doing delete");
		Connection conn = mysqlDS.getConnection();
		PreparedStatement statement = conn.prepareStatement("delete from manufacturer where manu_code = ?");
		statement.setString(1, m.getManu_code());

		statement.executeUpdate();

		conn.close();
		statement.close();

	} // delete

}
