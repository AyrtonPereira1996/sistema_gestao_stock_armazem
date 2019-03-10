package mz.com.SistemaArmazemFCSP.testes;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import mz.com.SistemaArmazemFCSP.DAO.SaidaProductoDAO;
import mz.com.SistemaArmazemFCSP.domain.SaidaProducto;

public class SaidaProductoTeste {
	
	@Test
	public void listar() throws SQLException{
		SaidaProductoDAO spdao = new SaidaProductoDAO();
		ArrayList<SaidaProducto> lista = spdao.listar();
		for(SaidaProducto sp : lista) {
			System.out.println("codigo : " + sp.getIdSaida());
			System.out.println("requisicao : " + sp.getRequisicao().getId());
			System.out.println("Departamento : " + sp.getDepartamento().getNomeDepartamento());
			System.out.println("Funcionario : " + sp.getFuncionario().getNomeFuncionario());
			System.out.println("Funcionario : " + sp.getFuncionario().getApelidoFuncionario());
			System.out.println("Producto : " + sp.getProducto().getTipoProducto());
			System.out.println("Data : " + sp.getDataSaida());
			System.out.println("Quantidade : " + sp.getQuantidadeSaida());
			System.out.println("Descricao :" + sp.getDescricao());
			System.out.println(" ");
		}
		
	}
	
	
}
