package mz.com.SistemaArmazemFCSP.testes;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import mz.com.SistemaArmazemFCSP.DAO.ProductoDAO;
import mz.com.SistemaArmazemFCSP.domain.Producto;

public class ProductoTestes {

	@Test
	@Ignore
	public void inserir() throws SQLException, ParseException {

		Producto p = new Producto();
		p.setArtigo("0005");
		p.setTipoProducto("Laptops");
		p.setDescricao("Cor preta");
		p.setQuantidade(1000);
		p.setValidade("sem validade");

		ProductoDAO pdao = new ProductoDAO();
		pdao.inserir(p);

	}

	@Test
	@Ignore
	public void editar() throws SQLException, ParseException {

		Producto p = new Producto();
		p.setArtigo("0004");
		p.setTipoProducto("Canetas BIC");
		p.setDescricao("Cor verde");
		p.setQuantidade(500);
		p.setValidade("sem validade");
		p.setArtigo("0001");

		ProductoDAO pdao = new ProductoDAO();
		pdao.editar(p);
	}

	@Test
	@Ignore
	public void excluir() throws SQLException {
		Producto p = new Producto();
		p.setId(3);

		ProductoDAO pdao = new ProductoDAO();
		pdao.excluir(p);

	}

	@Test
	@Ignore
	public void listar() throws SQLException {
		ProductoDAO pdao = new ProductoDAO();
		ArrayList<Producto> lista = pdao.listar();
		for (Producto p : lista) {
			System.out.println("Artigo : " + p.getArtigo());
			System.out.println("Dta : " + p.getDataRegisto());
			System.out.println("Tipo Producto : " + p.getTipoProducto());
			System.out.println("Descricao : " + p.getDescricao());
			System.out.println("Quantidade : " + p.getQuantidade());
			System.out.println("Validade : " + p.getValidade());
			System.out.println("");

		}
	}

	@Test
	public void listarProducto() throws SQLException {
		ProductoDAO pdao = new ProductoDAO();
		ArrayList<Producto> lista = pdao.listarProducto();
		for (Producto p : lista) {
			System.out.println("Codigo producto : " + p.getId());
			System.out.println("Producto : " + p.getTipoProducto());
			System.out.println("Quantidade : " + p.getQuantidade());
			System.out.println(" ");
		}

	}

}
