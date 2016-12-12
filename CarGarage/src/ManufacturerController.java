
import java.sql.SQLException;
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

	public ManufacturerController() {
		try {
			dao = new DAO();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * 
	 * Methods for ManufacturerController Object
	 * 
	 */

	// returns ArrayList of manufacturers
	public ArrayList<Manufacturer> getManufacturers() {
		return manufacturers;
	}

	// attempt to call addManufacturer method in DB, or throw exception message
	// to user
	public void addManufacturer(Manufacturer s) throws Exception {
		try {
			dao.addManufacturer(s); // call dao method to check uniquess and add
									// details to db
			System.out.println("Manufacturer is unique, adding to DB");
			/* internal redirection */
			FacesContext.getCurrentInstance().getExternalContext().redirect("manage_manufacturers.xhtml"); // redirect
																											// to
																											// manufacturers
																											// page
		} catch (MySQLIntegrityConstraintViolationException e) {
			FacesMessage message = new FacesMessage(e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, message); // if
																			// there
																			// is
																			// an
																			// error
																			// display
																			// to
																			// user
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// attempt to call loadManufactuers method in DB
	public ArrayList<Manufacturer> loadManufacturers() throws Exception {
		return manufacturers = dao.getManufacturerDetails(); // call dao method
																// to retreive
																// details

	}

	// attempt to call deleteManufactuer method in DB, or throw exception
	// message to user
	public void deleteManufacturer(Manufacturer s) {
		try {
			System.out.println("Trying delete");
			dao.delete(s); // Attempt to delete the manufacturer
			FacesContext.getCurrentInstance().getExternalContext().redirect("manage_manufacturers.xhtml"); // redirect
																											// to
																											// manufacturer
																											// page
		} catch (SQLException e) {
			FacesMessage msg = new FacesMessage("Error" + e);
			FacesContext.getCurrentInstance().addMessage(null, msg); // if there
																		// is an
																		// error
																		// from
																		// constraint
																		// or
																		// foreign
																		// key.
																		// Prompt
																		// to
																		// user
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
