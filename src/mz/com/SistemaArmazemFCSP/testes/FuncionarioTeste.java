package mz.com.SistemaArmazemFCSP.testes;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import mz.com.SistemaArmazemFCSP.DAO.FuncionarioDAO;
import mz.com.SistemaArmazemFCSP.domain.Departamento;
import mz.com.SistemaArmazemFCSP.domain.Funcionario;

public class FuncionarioTeste {

	@Test
	public void inserir() throws SQLException {
		Funcionario f = new Funcionario();
		f.setNomeFuncionario("Francisco");
		f.setApelidoFuncionario("Fernando");
		f.setSexoFuncionario("M");
		f.setCargoFuncionario("Docente");
		f.setEnderecoElectronico("Francisco@otmail.com");
		f.setContacto("847054326");

		Departamento d = new Departamento();
		d.setIdDepartamento(1);
		f.setDepartamento(d);

		FuncionarioDAO fdao = new FuncionarioDAO();
		fdao.inserir(f);

	}

	@Test
	@Ignore
	public void editar() throws SQLException {
		Funcionario f = new Funcionario();
		f.setNomeFuncionario("Edson");
		f.setApelidoFuncionario("Xavier");
		f.setSexoFuncionario("M");
		f.setCargoFuncionario("Docente");
		f.setEnderecoElectronico("ffffff@hhhhh.coom");
		f.setContacto("847575757");
		f.setId(11);

		Departamento d = new Departamento();
		d.setIdDepartamento(26);
		f.setDepartamento(d);

		FuncionarioDAO fdao = new FuncionarioDAO();
		fdao.editar(f);
	}
	
	@Test
	@Ignore
	public void excluir() throws SQLException{
		Funcionario f = new Funcionario();
		f.setId(7);
		
		FuncionarioDAO fdao = new FuncionarioDAO();
		fdao.excluir(f);
	}
	
	@Test
	@Ignore
	public void listar() throws SQLException{
		FuncionarioDAO fdao = new FuncionarioDAO();
		ArrayList<Funcionario> lista = fdao.listar();
		for(Funcionario f : lista) {
			System.out.println("Codigo funcionario " + f.getId());
			System.out.println("Departamento " + f.getDepartamento().getNomeDepartamento());
			System.out.println("Nome do Funcionario " + f.getNomeFuncionario());
			System.out.println("Apelido do funcionario " + f.getApelidoFuncionario());
			System.out.println("Sexo " + f.getSexoFuncionario());
			System.out.println("Cargo " + f.getCargoFuncionario());
			System.out.println("Endereco electronico " + f.getEnderecoElectronico());
			System.out.println(" ");
			
		}
		
		
	}

}
