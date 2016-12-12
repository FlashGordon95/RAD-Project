
import java.util.ArrayList;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

@ManagedBean(name = "vehicleController")
@SessionScoped
public class VehicleController {
	private ArrayList<Vehicle> vehicles;
	private DAO dao;
	private String reg;

	public VehicleController() {
		try {
			dao = new DAO();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * 
	 * Methods for ModelController Object
	 * 
	 */

	// returns ArrayList of vehicles
	public ArrayList<Vehicle> getModels() {
		return vehicles;
	}

	// attempt to call addVehicle method in DB, or throw exception message to
	// user
	public void addVehicle(Vehicle s) throws Exception {
		try {
			dao.addVehicle(s);
			System.out.println("Vehicle is unique, adding to DB");
			/* internal redirection */
			FacesContext.getCurrentInstance().getExternalContext().redirect("manage_vehicles.xhtml");
		} catch (MySQLIntegrityConstraintViolationException e) {
			FacesMessage message = new FacesMessage(e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, message);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// attempt to call loadDetails method in DB, or throw exception
	public ArrayList<Vehicle> loadDetails(String reg) throws Exception {
		vehicles = dao.getSpecificVehicleDetails(reg);

		return vehicles;
	}

	// attempt to call loadVehicles method in DB, or throw exception
	public ArrayList<Vehicle> loadVehicles() throws Exception {
		return vehicles = dao.getVehicleDetails();

	}

}
