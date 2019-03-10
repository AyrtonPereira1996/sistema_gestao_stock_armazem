package mz.com.SistemaArmazemFCSP.Beans;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import mz.com.SistemaArmazemFCSP.DAO.EntradaProductoDAO;
import mz.com.SistemaArmazemFCSP.domain.EntradaProducto;


@ManagedBean(name = "MBEntradaProducto")
@ViewScoped
public class EntradaProductoBean {

	private ArrayList<EntradaProducto> itens;
	private ArrayList<EntradaProducto> itensFiltrados;

	public ArrayList<EntradaProducto> getItens() {
		return itens;
	}
	
	public void setItens(ArrayList<EntradaProducto> itens) {
		this.itens = itens;
	}
	
	public ArrayList<EntradaProducto> getItensFiltrados() {
		return itensFiltrados;
	}
	
	public void setItensFiltrados(ArrayList<EntradaProducto> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}
	
	@PostConstruct
	public void prepararPesquisa() {
		try {
			EntradaProductoDAO epdao = new EntradaProductoDAO();
			itens=epdao.listar();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}


}
