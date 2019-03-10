package mz.com.SistemaArmazemFCSP.testes;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import mz.com.SistemaArmazemFCSP.DAO.HistorialProductoDAO;
import mz.com.SistemaArmazemFCSP.domain.HistorialProducto;

public class HistorialProductoTeste {

	@Test
	public void listar() throws SQLException{
		HistorialProductoDAO hpDAO = new HistorialProductoDAO();
		ArrayList<HistorialProducto> lista = hpDAO.listar();
		
		for(HistorialProducto hp : lista) {
		System.out.println("Codigo : " + hp.getIdHistorial() );
		System.out.println("Tipo producto :" + hp.getProducto().getTipoProducto());
		System.out.println("Descricao : " + hp.getDescricao());
		System.out.println("Data :" + hp.getProducto().getDataRegisto());
		System.out.println("Data de modificação :" + hp.getDataModificacao());
		System.out.println("");
		
		
		}
		
	}
}
