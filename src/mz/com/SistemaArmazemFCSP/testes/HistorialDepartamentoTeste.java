package mz.com.SistemaArmazemFCSP.testes;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import mz.com.SistemaArmazemFCSP.DAO.HistorialDepartamentoDAO;
import mz.com.SistemaArmazemFCSP.domain.HistorialDepartamento;

public class HistorialDepartamentoTeste {
	
	@Test
	public void listar() throws SQLException {
		HistorialDepartamentoDAO hDAO = new HistorialDepartamentoDAO();
		ArrayList<HistorialDepartamento> lista = hDAO.listar();
		for(HistorialDepartamento hd: lista) {
			System.out.println("Codigo : " + hd.getIdHistorialDepartamento());
			System.out.println("Codigo de departamento : " + hd.getDepartamento().getCodDepartamento());
			System.out.println("Nome do departamento : " + hd.getDepartamento().getNomeDepartamento());
			System.out.println("Descrição : " + hd.getDescricao() );
			System.out.println("Data de registo :" + hd.getDepartamento().getDataRegisto());
			System.out.println("Data de modificação :" + hd.getDataModificacao());
			System.out.println(" ");
		}
		
		
		
	}
}
