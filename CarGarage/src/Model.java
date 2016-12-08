


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean
public class Model {
	private String manu_code;
	private String model_code;
	private String model_name;
	private String model_desc;
	
	public Model(){
		
	}
	
	public Model(String manu_name, String model_code, String model_name, String model_desc) {
		super();
		this.manu_code = manu_name;
		this.model_code = model_code;
		this.model_name = model_name;
		this.model_desc = model_desc;
		
	}

	public String getManu_code() {
		return manu_code;
	}

	public void setManu_code(String manu_code) {
		this.manu_code = manu_code;
	}

	public String getModel_code() {
		return model_code;
	}

	public void setModel_code(String model_code) {
		this.model_code = model_code;
	}

	public String getModel_name() {
		return model_name;
	}

	public void setModel_name(String model_name) {
		this.model_name = model_name;
	}

	public String getModel_desc() {
		return model_desc;
	}

	public void setModel_desc(String model_desc) {
		this.model_desc = model_desc;
	}

	
	

}

