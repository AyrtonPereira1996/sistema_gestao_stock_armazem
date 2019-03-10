package mz.com.SistemaArmazemFCSP.Beans;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import mz.com.SistemaArmazemFCSP.DAO.SaidaProductoDAO;
import mz.com.SistemaArmazemFCSP.domain.SaidaProducto;
import mz.com.SistemaArmazemFCSP.util.Mensagens;

@ManagedBean (name="MBSaidaProducto")
@ViewScoped
public class SaidaProductoBean {
	private SaidaProducto saidaProducto;
	private ArrayList<SaidaProducto> itens;
	private ArrayList<SaidaProducto> itensFiltrados;
	
	
	public SaidaProducto getSaidaProducto() {
		return saidaProducto;
	}
	
	public void setSaidaProducto(SaidaProducto saidaProducto) {
		this.saidaProducto = saidaProducto;
	}
	
	public ArrayList<SaidaProducto> getItens() {
		return itens;
	}
	
	public void setItens(ArrayList<SaidaProducto> itens) {
		this.itens = itens;
	}
	
	public ArrayList<SaidaProducto> getItensFiltrados() {
		return itensFiltrados;
	}
	
	public void setItensFiltrados(ArrayList<SaidaProducto> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}
	
	@PostConstruct
	public void prepararPesquisa() {
		
		try {
			SaidaProductoDAO spdao= new SaidaProductoDAO();
			itens = spdao.listar();
		} catch (SQLException e) {
			Mensagens.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
	}
	
}
