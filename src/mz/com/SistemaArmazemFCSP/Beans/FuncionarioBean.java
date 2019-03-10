package mz.com.SistemaArmazemFCSP.Beans;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import mz.com.SistemaArmazemFCSP.DAO.DepartamentoDAO;
import mz.com.SistemaArmazemFCSP.DAO.FuncionarioDAO;
import mz.com.SistemaArmazemFCSP.domain.Departamento;
import mz.com.SistemaArmazemFCSP.domain.Funcionario;
import mz.com.SistemaArmazemFCSP.util.Mensagens;

@ManagedBean(name = "MBFuncionario")
@ViewScoped
public class FuncionarioBean {
	private Funcionario funcionario;

	private ArrayList<Funcionario> itens;

	private ArrayList<Funcionario> itensFiltrados;
	
	private ArrayList<Departamento> comboDepartamento;

	public ArrayList<Departamento> getComboDepartamento() {
		return comboDepartamento;
	}
	
	public void setComboDepartamento(ArrayList<Departamento> comboDepartamento) {
		this.comboDepartamento = comboDepartamento;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public ArrayList<Funcionario> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Funcionario> itens) {
		this.itens = itens;
	}

	public void setItensFiltrados(ArrayList<Funcionario> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	public ArrayList<Funcionario> getItensFiltrados() {
		return itensFiltrados;
	}



	public void prepararInsercao() {
		
		try {
			funcionario = new Funcionario();
			DepartamentoDAO ddao = new DepartamentoDAO();
			comboDepartamento = ddao.listar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
	public void prepararEditar() {
		
		try {
			funcionario = new Funcionario();
			DepartamentoDAO ddao = new DepartamentoDAO();
			comboDepartamento = ddao.listar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@PostConstruct
	public void prepararPesquisa() {

		try {
			FuncionarioDAO fdao = new FuncionarioDAO();
			itens = fdao.listar();
		} catch (SQLException e) {
			Mensagens.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
	}

	public void inserir() {

		try {
			FuncionarioDAO fdao = new FuncionarioDAO();
			fdao.inserir(funcionario);
			itens = fdao.listar();
			Mensagens.adicionarMensagemSucesso("Salvo com sucesso!");
		} catch (SQLException e) {
			Mensagens.adicionarMensagemErro("Não é possivel registar o funcionário!");
			e.printStackTrace();
		}

	}
	
	public void excluir() {
		
		try {
			FuncionarioDAO fdao = new FuncionarioDAO();
			fdao.excluir(funcionario);
			itens=fdao.listar();
			Mensagens.adicionarMensagemSucesso("Excluído com sucesso!");
		} catch (SQLException e) {
			Mensagens.adicionarMensagemErro("Não é possivel excluir um funcionário!");
			e.printStackTrace();
		}		
	}
	
	public void editar() {
		
		
		try {
			FuncionarioDAO fdao = new FuncionarioDAO();
			fdao.editar(funcionario);
			itens=fdao.listar();
			Mensagens.adicionarMensagemSucesso("Editado com sucesso!");
		} catch (SQLException e) {
			Mensagens.adicionarMensagemErro("Não é possivel editar o funcionário!");
			e.printStackTrace();
		}
	}
}
