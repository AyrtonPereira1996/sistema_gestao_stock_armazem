package mz.com.SistemaArmazemFCSP.testes;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import mz.com.SistemaArmazemFCSP.DAO.RequisicaoDAO;
import mz.com.SistemaArmazemFCSP.domain.Departamento;
import mz.com.SistemaArmazemFCSP.domain.Funcionario;
import mz.com.SistemaArmazemFCSP.domain.Producto;
import mz.com.SistemaArmazemFCSP.domain.Requisicao;

public class RequisicaoTestes {

	@Test
	@Ignore
	public void inserir() throws SQLException {
		Departamento d = new Departamento();
		d.setIdDepartamento(1);

		Funcionario f = new Funcionario();
		f.setId(14);

		Producto p = new Producto();
		p.setId(20);

		Requisicao r = new Requisicao();
		r.setDepartamento(d);
		r.setFuncionario(f);
		r.setProducto(p);
		r.setQuantidade(150);
		RequisicaoDAO rdao = new RequisicaoDAO();
		rdao.inserir(r);

	}

	@Test
	@Ignore
	public void excluir() throws SQLException {
		Requisicao r = new Requisicao();
		r.setId(7);

		RequisicaoDAO rdao = new RequisicaoDAO();
		rdao.excluir(r);

	}

	@Test
	@Ignore
	public void editar() throws SQLException {
		Departamento d = new Departamento();
		d.setIdDepartamento(10);

		Funcionario f = new Funcionario();
		f.setId(9);

		Producto p = new Producto();
		p.setId(18);

		Requisicao r = new Requisicao();
		r.setDepartamento(d);
		r.setFuncionario(f);
		r.setProducto(p);
		r.setQuantidade(1);
		r.setId(1);

		RequisicaoDAO rdao = new RequisicaoDAO();
		rdao.editar(r);
	}

	@Test

	public void listar() throws SQLException {
		RequisicaoDAO rdao = new RequisicaoDAO();
		ArrayList<Requisicao> lista = rdao.listar();
		for (Requisicao r : lista) {
			System.out.println("Codigo requisicao :" + r.getId());
			System.out.println("Departamento :" + r.getDepartamento().getNomeDepartamento());
			System.out.println("Nome :" + r.getFuncionario().getNomeFuncionario());
			System.out.println("Departamento :" + r.getDepartamento().getNomeDepartamento());
			System.out.println("Producto :" + r.getProducto().getTipoProducto());
			System.out.println("Data : " + r.getDataRequisicao());
			System.out.println("Quantidade :" + r.getQuantidade());
			System.out.println(" ");

		}

	}

}
