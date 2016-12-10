


import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

@ManagedBean
public class ModelController {
	private ArrayList<Model> models;
	private DAO dao;
	
	public ModelController(){
		try{
			dao = new DAO();
		} catch(Exception e){
			e.printStackTrace();
		}
		
	}
	public ArrayList<Model> getModels(){
		return models;
	}
	
	
	public void addModel(Model s) throws Exception{
		try{
			dao.addModel(s);
			System.out.println("Model is unique, adding to DB");
			/* internal redirection */
			FacesContext.getCurrentInstance().getExternalContext().redirect("manage_models.xhtml");
		}catch (MySQLIntegrityConstraintViolationException e) {
			FacesMessage message = new FacesMessage(e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
	}
	public ArrayList<Model> loadModels() throws Exception{
		return models = dao.getModelDetails();
		
	}

}
