package mz.com.SistemaArmazemFCSP.Beans;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import mz.com.SistemaArmazemFCSP.DAO.DepartamentoDAO;
import mz.com.SistemaArmazemFCSP.DAO.FuncionarioDAO;
import mz.com.SistemaArmazemFCSP.DAO.ProductoDAO;
import mz.com.SistemaArmazemFCSP.DAO.RequisicaoDAO;
import mz.com.SistemaArmazemFCSP.domain.Departamento;
import mz.com.SistemaArmazemFCSP.domain.Funcionario;
import mz.com.SistemaArmazemFCSP.domain.Producto;
import mz.com.SistemaArmazemFCSP.domain.Requisicao;
import mz.com.SistemaArmazemFCSP.util.Mensagens;

@ManagedBean(name = "MBRequisicao")
@ViewScoped
public class RequisicaoBean {
	private Requisicao requisicao;
	private ArrayList<Requisicao> itens;
	private ArrayList<Requisicao> itensFiltrados;
	private ArrayList<Departamento> itensDepartamento;
	private ArrayList<Producto> itensProducto;
	private ArrayList<Funcionario> itensFuncionario;

	public ArrayList<Funcionario> getItensFuncionario() {
		return itensFuncionario;
	}
	
	public void setItensFuncionario(ArrayList<Funcionario> itensFuncionario) {
		this.itensFuncionario = itensFuncionario;
	}

	public ArrayList<Departamento> getItensDepartamento() {
		return itensDepartamento;
	}

	public void setItensDepartamento(ArrayList<Departamento> itensDepartamento) {
		this.itensDepartamento = itensDepartamento;
	}

	public ArrayList<Producto> getItensProducto() {
		return itensProducto;
	}

	public void setItensProducto(ArrayList<Producto> itensProducto) {
		this.itensProducto = itensProducto;
	}

	public ArrayList<Requisicao> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Requisicao> itens) {
		this.itens = itens;
	}

	public ArrayList<Requisicao> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Requisicao> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	public Requisicao getRequisicao() {
		return requisicao;
	}

	public void setRequisicao(Requisicao requisicao) {
		this.requisicao = requisicao;
	}

	public void prepararInsercao() {
		try {
			requisicao = new Requisicao();
			DepartamentoDAO ddao = new DepartamentoDAO();
			itensDepartamento = ddao.listar();
			
			ProductoDAO pdao = new ProductoDAO();
			itensProducto = pdao.listar();
			
			FuncionarioDAO fdao = new FuncionarioDAO();
			itensFuncionario = fdao.listar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void inserir() {

		try {
			RequisicaoDAO rdao = new RequisicaoDAO();
			rdao.inserir(requisicao);
			itens = rdao.listar();
			Mensagens.adicionarMensagemSucesso("Salvo com sucesso!");
		} catch (SQLException ex) {
			Mensagens.adicionarMensagemErro("Não é possivel registar a requisição!");
			ex.printStackTrace();
		}
	}

	@PostConstruct
	public void prepararPesquisa() {

		try {
			RequisicaoDAO rdao = new RequisicaoDAO();
			itens = rdao.listar();
		} catch (SQLException e) {
			Mensagens.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}

	}
	
	public void prepararEditar() {
		
		try {
			requisicao = new Requisicao();
			
			DepartamentoDAO ddao = new DepartamentoDAO();
			itensDepartamento = ddao.listar();
			
			FuncionarioDAO fdao = new FuncionarioDAO();
			itensFuncionario = fdao.listar();
			
			ProductoDAO pdao = new ProductoDAO();
			itensProducto = pdao.listar();
			
		} catch (SQLException e) {
			Mensagens.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
	}
	
	public void editar() {
		
		try {
			RequisicaoDAO rdao = new RequisicaoDAO();
			rdao.editar(requisicao);
			itens = rdao.listar();
			Mensagens.adicionarMensagemSucesso("Editado com sucesso!");
		} catch (SQLException e) {
			Mensagens.adicionarMensagemErro("Não é possivel editar a requisição!");
			e.printStackTrace();
		}
		
	}
	
	public void excluir() {
		
		try {
			RequisicaoDAO rdao = new RequisicaoDAO();
			rdao.excluir(requisicao);
			itens = rdao.listar();
			Mensagens.adicionarMensagemSucesso("Excluida com sucesso!");
		} catch (SQLException ex) {
			Mensagens.adicionarMensagemErro("Não é possivel excluir a requisição!");
			ex.printStackTrace();
		}
	}
	
}
