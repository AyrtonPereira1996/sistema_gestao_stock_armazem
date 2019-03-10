package mz.com.SistemaArmazemFCSP.testes;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import mz.com.SistemaArmazemFCSP.DAO.HistorialFuncionarioDAO;
import mz.com.SistemaArmazemFCSP.domain.HistorialFuncionario;

public class HistorialFuncionarioTeste {

	@Test
	public void listar() throws SQLException{
		HistorialFuncionarioDAO hDAO = new HistorialFuncionarioDAO();
		ArrayList<HistorialFuncionario> lista = hDAO.listar();
		
		for (HistorialFuncionario hf : lista) {
			System.out.println("Codigo : " + hf.getIdHistorialFuncionario());
			System.out.println("Nome funcionário : " + hf.getFuncionario().getNomeFuncionario());
			System.out.println("Apelido funcionario : " + hf.getFuncionario().getApelidoFuncionario());
			System.out.println("Cargo funcionario : " + hf.getFuncionario().getCargoFuncionario() );
			System.out.println("Departamento : " + hf.getDepartamento().getNomeDepartamento());
			System.out.println("Descricao : " + hf.getDescricao());
			System.out.println("Data de registo : " + hf.getFuncionario().getDataRegisto());
			System.out.println("Data de modificaçao : " + hf.getDataModificacao());
			System.out.println(" ");
		}
		
		
	}

}
