


import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

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
	
	
	/*public String addStudent(Manufacturer s) throws Exception{
		try{
			dao.addStudent(s);
			return "Added to DB";
		} catch (Exception e){
			return e.toString();
		}
		
	}
	*/
	public ArrayList<Vehicle> loadVehicles() throws Exception{
		return models = dao.getVehicleDetails();
		
	}

}
