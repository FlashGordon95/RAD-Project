


import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class ManufacturerController {
	private ArrayList<Manufacturer> manufacturers;
	private DAO dao;
	
	public ManufacturerController(){
		try{
			dao = new DAO();
		} catch(Exception e){
			e.printStackTrace();
		}
		
	}
	public ArrayList<Manufacturer> getManufacturers(){
		return manufacturers;
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
	public ArrayList<Manufacturer> loadManufacturers() throws Exception{
		return manufacturers = dao.getManufacturerDetails();
		
	}

}
