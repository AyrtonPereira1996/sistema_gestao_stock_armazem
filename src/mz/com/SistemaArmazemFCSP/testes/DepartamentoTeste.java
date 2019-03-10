package mz.com.SistemaArmazemFCSP.testes;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import mz.com.SistemaArmazemFCSP.DAO.DepartamentoDAO;
import mz.com.SistemaArmazemFCSP.domain.Departamento;

public class DepartamentoTeste {
	
	@Test
	@Ignore
	public void inserir() throws SQLException {
		Departamento d = new Departamento();
		d.setCodDepartamento("TI01");
		d.setNomeDepartamento("Departamento de Tecn. de Informação");
		d.setNomeCoordenador("Mohamed Shueib");

		DepartamentoDAO ddao = new DepartamentoDAO();
		ddao.inserir(d);

	}

	public void excluir() throws SQLException {

		Departamento d = new Departamento();
		d.setCodDepartamento("0");

		DepartamentoDAO dao = new DepartamentoDAO();
		dao.excluir(d);

	}

	public void editar() throws SQLException {
		Departamento d = new Departamento();
		d.setCodDepartamento("0007");
		d.setNomeDepartamento("ZZ");
		d.setNomeCoordenador("Francisco");
		d.setIdDepartamento(2);

		DepartamentoDAO dao = new DepartamentoDAO();
		dao.editar(d);

	}

	@Test
	public void listar() throws SQLException {
			DepartamentoDAO ddao = new DepartamentoDAO();
			ArrayList<Departamento> lista = ddao.listar();
			for(Departamento d : lista) {
				System.out.println("Codigo :" + d.getCodDepartamento());
				System.out.println("Id departamento :" + d.getIdDepartamento());
				System.out.println("Nome de departamento : " + d.getNomeDepartamento());
				System.out.println("Nome de coordenador :" + d.getNomeCoordenador());
				System.out.println("Data " + d.getDataRegisto());
		
			}
			
			
	}

}
