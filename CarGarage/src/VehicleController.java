


import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

@ManagedBean
public class VehicleController {
	private ArrayList<Vehicle> models;
	private DAO dao;
	
	public VehicleController(){
		try{
			dao = new DAO();
		} catch(Exception e){
			e.printStackTrace();
		}
		
	}
	public ArrayList<Vehicle> getModels(){
		return models;
	}
	
	
	public void addVehicle(Vehicle s) throws Exception{
		try{
			dao.addVehicle(s);
			System.out.println("Vehicle is unique, adding to DB");
			/* internal redirection */
			FacesContext.getCurrentInstance().getExternalContext().redirect("manage_vehicles.xhtml");
		}catch (MySQLIntegrityConstraintViolationException e) {
			FacesMessage message = new FacesMessage(e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
	}
	public ArrayList<Vehicle> loadVehicles() throws Exception{
		return models = dao.getVehicleDetails();
		
	}

}
