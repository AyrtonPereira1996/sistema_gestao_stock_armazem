package mz.com.SistemaArmazemFCSP.Beans;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import mz.com.SistemaArmazemFCSP.DAO.HistorialFuncionarioDAO;
import mz.com.SistemaArmazemFCSP.domain.HistorialFuncionario;

@ManagedBean (name="MBHistorialFuncionario")
@ViewScoped
public class HistorialFuncionarioBean {
	private HistorialFuncionario historialFuncionario;
	private ArrayList<HistorialFuncionario> itens;
	private ArrayList<HistorialFuncionario> itensFiltrados;
	
	public HistorialFuncionario getHistorialFuncionario() {
		return historialFuncionario;
	}
	
	public void setHistorialFuncionario(HistorialFuncionario historialFuncionario) {
		this.historialFuncionario = historialFuncionario;
	}
	
	public ArrayList<HistorialFuncionario> getItens() {
		return itens;
	}
	
	public void setItens(ArrayList<HistorialFuncionario> itens) {
		this.itens = itens;
	}
	
	public ArrayList<HistorialFuncionario> getItensFiltrados() {
		return itensFiltrados;
	}
	
	public void setItensFiltrados(ArrayList<HistorialFuncionario> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}
	
	
	@PostConstruct
	public void prepararPesquisa() {
		try {
			HistorialFuncionarioDAO hfdao = new HistorialFuncionarioDAO();
			itens = hfdao.listar();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}
	
}
