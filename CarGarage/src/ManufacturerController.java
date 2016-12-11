


import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

@ManagedBean
@SessionScoped
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
	
	
	public void addManufacturer(Manufacturer s) throws Exception{
		try{
			dao.addManufacturer(s);
			System.out.println("Manufacturer is unique, adding to DB");
			/* internal redirection */
			FacesContext.getCurrentInstance().getExternalContext().redirect("manage_manufacturers.xhtml");
		}catch (MySQLIntegrityConstraintViolationException e) {
			FacesMessage message = new FacesMessage(e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Manufacturer> loadManufacturers() throws Exception{
		return manufacturers = dao.getManufacturerDetails();
		
	}

}
