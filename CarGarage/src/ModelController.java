


import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

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
	
	
	/*public String addStudent(Manufacturer s) throws Exception{
		try{
			dao.addStudent(s);
			return "Added to DB";
		} catch (Exception e){
			return e.toString();
		}
		
	}
	*/
	public ArrayList<Model> loadModels() throws Exception{
		return models = dao.getModelDetails();
		
	}

}
