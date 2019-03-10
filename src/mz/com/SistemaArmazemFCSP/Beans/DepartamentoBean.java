package mz.com.SistemaArmazemFCSP.Beans;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import mz.com.SistemaArmazemFCSP.DAO.DepartamentoDAO;
import mz.com.SistemaArmazemFCSP.domain.Departamento;
import mz.com.SistemaArmazemFCSP.util.Mensagens;

@ManagedBean(name = "MBDepartamento")
@ViewScoped
public class DepartamentoBean {

	private Departamento departamento;
	private ArrayList<Departamento> itens;
	private ArrayList<Departamento> itensListados;

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public ArrayList<Departamento> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Departamento> itens) {
		this.itens = itens;
	}

	public ArrayList<Departamento> getItensListados() {
		return itensListados;
	}

	public void setItensListados(ArrayList<Departamento> itensListados) {
		this.itensListados = itensListados;
	}

	public void prepararInsercao() {
		departamento = new Departamento();
	}

	public void inserir() { // Metodo que permite inserir registos na tabela departamento

		try {
			DepartamentoDAO ddao = new DepartamentoDAO();
			ddao.inserir(departamento);
			itens = ddao.listar();
			Mensagens.adicionarMensagemSucesso("Salvo com sucesso!");
		} catch (SQLException e) {
			Mensagens.adicionarMensagemErro("Não é possivel registar o departamento!");
			e.printStackTrace();
		}

	}

	public void excluir() {

		try {
			DepartamentoDAO ddao = new DepartamentoDAO();
			ddao.excluir(departamento);
			itens = ddao.listar();
			Mensagens.adicionarMensagemSucesso("Excluído com sucesso!");
		} catch (SQLException e) {
			Mensagens.adicionarMensagemErro("Não é possivel excluir o departamento!");
			e.printStackTrace();
		}

	}

	public void editar() {

		try {
			DepartamentoDAO ddao = new DepartamentoDAO();
			ddao.editar(departamento);
			Mensagens.adicionarMensagemSucesso("Editado com sucesso!");
		} catch (SQLException e) {
			Mensagens.adicionarMensagemErro("Não é possivel editar o departamento!");
			e.printStackTrace();
		}
	}

	@PostConstruct
	public void prepararPesquisa() {

		try {
			DepartamentoDAO ddao = new DepartamentoDAO();
			itens = ddao.listar();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
