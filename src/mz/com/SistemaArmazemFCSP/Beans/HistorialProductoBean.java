package mz.com.SistemaArmazemFCSP.Beans;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import mz.com.SistemaArmazemFCSP.DAO.HistorialProductoDAO;
import mz.com.SistemaArmazemFCSP.domain.HistorialProducto;


@ManagedBean(name="MBHistorialProducto")
@ViewScoped

public class HistorialProductoBean {
	private HistorialProducto historialProducto = new HistorialProducto();
	private ArrayList<HistorialProducto> itens;
	private ArrayList<HistorialProducto> itensFiltrados;
	
	public HistorialProducto getHistorialProducto() {
		return historialProducto;
	}
	
	public void setHistorialProducto(HistorialProducto historialProducto) {
		this.historialProducto = historialProducto;
	}
	
	public ArrayList<HistorialProducto> getItens() {
		return itens;
	}
	
	public void setItens(ArrayList<HistorialProducto> itens) {
		this.itens = itens;
	}
	
	public ArrayList<HistorialProducto> getItensFiltrados() {
		return itensFiltrados;
	}
	
	public void setItensFiltrados(ArrayList<HistorialProducto> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}
	
	@PostConstruct
	public void prepararPesquisa() {
		try {
			HistorialProductoDAO hpdao = new HistorialProductoDAO();
			itens = hpdao.listar();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
}
