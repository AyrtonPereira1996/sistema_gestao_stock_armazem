package mz.com.SistemaArmazemFCSP.Beans;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import mz.com.SistemaArmazemFCSP.DAO.HistorialDepartamentoDAO;
import mz.com.SistemaArmazemFCSP.domain.HistorialDepartamento;


@ManagedBean (name="MBHistorialDepartamento")
@ViewScoped
public class HistorialDepartamentoBean {
	
	private HistorialDepartamento historialDepartamento;
	private ArrayList<HistorialDepartamento> itens;
	private ArrayList<HistorialDepartamento> itensFiltrados;
	
	public HistorialDepartamento getHistorialDepartamento() {
		return historialDepartamento;
	}
	
	public void setHistorialDepartamento(HistorialDepartamento historialDepartamento) {
		this.historialDepartamento = historialDepartamento;
	}
	
	public ArrayList<HistorialDepartamento> getItens() {
		return itens;
	}
	
	public void setItens(ArrayList<HistorialDepartamento> itens) {
		this.itens = itens;
	}
	
	public ArrayList<HistorialDepartamento> getItensFiltrados() {
		return itensFiltrados;
	}
	
	public void setItensFiltrados(ArrayList<HistorialDepartamento> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}
		
	@PostConstruct
	public void prepararPesquisa() {
		try {
			HistorialDepartamentoDAO hddao = new HistorialDepartamentoDAO();
			itens = hddao.listar();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}
	
	
}
