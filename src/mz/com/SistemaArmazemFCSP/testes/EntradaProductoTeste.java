package mz.com.SistemaArmazemFCSP.testes;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import mz.com.SistemaArmazemFCSP.DAO.EntradaProductoDAO;
import mz.com.SistemaArmazemFCSP.domain.EntradaProducto;

public class EntradaProductoTeste {
	
	@Test
	public void listar() throws SQLException {
		EntradaProductoDAO epdao= new EntradaProductoDAO();
		ArrayList<EntradaProducto> lista = epdao.listar();
		for(EntradaProducto ep : lista) {
			System.out.println("Id entrada " + ep.getIdEntrada());
			System.out.println("Tipo producto :" + ep.getProducto().getTipoProducto());
			System.out.println("Data : " + ep.getDataEntrada());
			System.out.println("Quantidade : " + ep.getQuantidade_entrada());
			System.out.println("Descricao :" + ep.getDescricao());
			System.out.println("");
		}
		
	}
}
