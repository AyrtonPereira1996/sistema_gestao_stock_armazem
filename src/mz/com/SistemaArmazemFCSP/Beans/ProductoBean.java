package mz.com.SistemaArmazemFCSP.Beans;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


import org.primefaces.model.chart.PieChartModel;

import mz.com.SistemaArmazemFCSP.DAO.ProductoDAO;
import mz.com.SistemaArmazemFCSP.domain.Producto;
import mz.com.SistemaArmazemFCSP.util.Mensagens;

@ManagedBean(name = "MBProducto")
@ViewScoped
public class ProductoBean {
	private Producto producto;
	private ArrayList<Producto> itens;
	private ArrayList<Producto> itensFiltrados;
	private PieChartModel graficoProducto;

	public PieChartModel getGraficoProducto() {
		return graficoProducto;
	}

	public void setGraficoProducto(PieChartModel graficoProducto) {
		this.graficoProducto = graficoProducto;
	}

	public ArrayList<Producto> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Producto> itens) {
		this.itens = itens;
	}

	public ArrayList<Producto> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Producto> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public void prepararInsercao() {
		producto = new Producto();

	}

	public void insercao() {

		try {
			ProductoDAO pdao = new ProductoDAO();
			pdao.inserir(producto);
			itens = pdao.listar();
			Mensagens.adicionarMensagemSucesso("Salvo com sucesso!");
		} catch (SQLException ex) {
			Mensagens.adicionarMensagemErro("Não é possivel registar o produto!");
			ex.printStackTrace();
		}
	}

	@PostConstruct
	public void prepararPesquisa() {

		try {
			ProductoDAO pdao = new ProductoDAO();
			itens = pdao.listar();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void edicao() {

		try {
			ProductoDAO pdao = new ProductoDAO();
			pdao.editar(producto);
			itens = pdao.listar();
			Mensagens.adicionarMensagemSucesso("Editado com sucesso!");
		} catch (SQLException ex) {
			Mensagens.adicionarMensagemErro("Não é possivel editar o produto!");
			ex.printStackTrace();
		}
	}
	
	public void acrescimoProducto() {
		
		try {
			ProductoDAO pdao = new ProductoDAO();
			pdao.acrescimoProducto(producto);
			Mensagens.adicionarMensagemSucesso("Acréscimo de produto realizado com sucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void exclusao() {

		try {
			ProductoDAO pdao = new ProductoDAO();
			pdao.excluir(producto);
			itens = pdao.listar();
			Mensagens.adicionarMensagemSucesso("Excluído com sucesso!");
		} catch (SQLException ex) {
			Mensagens.adicionarMensagemErro("Não é possivel excluir o produto!");
			ex.printStackTrace();
		}
	}

	public void ListarProducto() {
			Producto p = new Producto();
		try {
			
			ProductoDAO pdao = new ProductoDAO();
			ArrayList<Producto> lista = pdao.listarProducto();
			prepararGrafico(lista);
			System.out.println("aqui");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void prepararGrafico(ArrayList<Producto> lista) {
		graficoProducto = new PieChartModel();

		for (Producto p : lista) {
			graficoProducto.set(p.getTipoProducto(), p.getQuantidade());
		}
		graficoProducto.setTitle("Productos disponíveis");
		graficoProducto.setLegendPosition("e");
		graficoProducto.setFill(false);
		graficoProducto.setShowDataLabels(true);
		graficoProducto.setDiameter(150);
		System.out.println("aqui");

	}

}
