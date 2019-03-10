package mz.com.SistemaArmazemFCSP.Beans;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="MBIncludesBean")
public class IncludesBean {
	
	private String orientation = "vertical";
	
	public String getOrientation() {
		return orientation;
	}
	
	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

}
