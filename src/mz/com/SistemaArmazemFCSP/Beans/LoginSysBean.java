package mz.com.SistemaArmazemFCSP.Beans;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import mz.com.SistemaArmazemFCSP.DAO.LoginSysDAO;
import mz.com.SistemaArmazemFCSP.domain.LoginSys;


@ManagedBean(name=("MBLoginSys"))
@ViewScoped
public class LoginSysBean {
	private LoginSys ls;
	private ArrayList<LoginSys> itens;
	private ArrayList<LoginSys> itensListados;
	
	public ArrayList<LoginSys> getItens() {
		return itens;
	}
	
	public void setItens(ArrayList<LoginSys> itens) {
		this.itens = itens;
	}
	
	public ArrayList<LoginSys> getItensListados() {
		return itensListados;
	}
	
	public void setItensListados(ArrayList<LoginSys> itensListados) {
		this.itensListados = itensListados;
	}
	
	public LoginSys getLs() {
		return ls;
	}
	
	public void setLs(LoginSys ls) {
		this.ls = ls;
	}
	
	@PostConstruct
	public void prepararPesquisa() {
		
		try {
			LoginSysDAO lsdao = new LoginSysDAO();
			itens= lsdao.listar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
