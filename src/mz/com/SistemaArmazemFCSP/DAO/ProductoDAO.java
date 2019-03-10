package mz.com.SistemaArmazemFCSP.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mz.com.SistemaArmazemFCSP.domain.Producto;
import mz.com.SistemaArmazemFCSP.factory.Conexao;

public class ProductoDAO {
	public void inserir(Producto p) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("insert into producto ");
		sql.append("(artigo, data, tipoProducto, descricao, quantidade, validade) ");
		sql.append("values(?, now(), ?, ?, ?, ?)");
		
		Connection conexao = Conexao.conectar();
		
		PreparedStatement stmt = conexao.prepareStatement(sql.toString());
		stmt.setString(1, p.getArtigo());
		stmt.setString(2, p.getTipoProducto());
		stmt.setString(3, p.getDescricao());
		stmt.setInt(4, p.getQuantidade());
		stmt.setString(5, p.getValidade());
		stmt.executeUpdate();
		stmt.close();
		
	}
	
	public void acrescimoProducto(Producto p) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("update producto ");
		sql.append("set quantidade=? ");
		sql.append("where artigo=? ");
		
		Connection conexao = Conexao.conectar();
		
		PreparedStatement stmt=conexao.prepareStatement(sql.toString());
		stmt.setInt(1, p.getQuantidade());
		stmt.setString(2, p.getArtigo());
		stmt.executeUpdate();
		stmt.close();
	}
	
	public void editar(Producto p) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("update producto ");
		sql.append("set artigo=?, tipoProducto=?, descricao=?, quantidade=?, validade=? ");
		sql.append("where artigo=?");
		
		Connection conexao = Conexao.conectar();
		
		PreparedStatement stmt=conexao.prepareStatement(sql.toString());
		stmt.setString(1, p.getArtigo());
		stmt.setString(2, p.getTipoProducto());
		stmt.setString(3, p.getDescricao());
		stmt.setInt(4, p.getQuantidade());
		stmt.setString(5, p.getValidade());
		stmt.setString(6, p.getArtigo());
		stmt.executeUpdate();
		stmt.close();
	}
	
	public void excluir(Producto p) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("delete from producto ");
		sql.append("where artigo=?" );
		
		Connection conexao = Conexao.conectar();
		PreparedStatement stmt = conexao.prepareStatement(sql.toString());
		stmt.setString(1, p.getArtigo());
		stmt.executeUpdate();
		stmt.close();
	}
	
	public ArrayList<Producto> listar() throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("select idProducto, artigo, data, tipoProducto, descricao, quantidade, validade ");
		sql.append("from producto ");
		sql.append("order by artigo asc");
		
		Connection conexao = Conexao.conectar();
		PreparedStatement stmt = conexao.prepareStatement(sql.toString());
				
		ResultSet resultado = stmt.executeQuery();
		
		ArrayList<Producto> lista = new ArrayList<Producto>();
		
		while(resultado.next()) {
			Producto p = new Producto();
			p.setId(resultado.getInt("idproducto"));
			p.setArtigo(resultado.getString("artigo"));
			p.setDataRegisto(resultado.getTimestamp("data"));
			p.setTipoProducto(resultado.getString("tipoProducto"));
			p.setDescricao(resultado.getString("descricao"));
			p.setQuantidade(resultado.getInt("quantidade"));
			p.setValidade(resultado.getString("validade"));
			lista.add(p);
			
		}
		
		return lista;
		
	}
	
	public ArrayList<Producto> listarProducto() throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("select idProducto, tipoProducto, quantidade from producto ");
		
		Connection conexao = Conexao.conectar();
		PreparedStatement stmt = conexao.prepareStatement(sql.toString());
		ResultSet resultado = stmt.executeQuery();
		ArrayList<Producto> lista = new ArrayList<Producto>();
		
		while(resultado.next()) {
			Producto p = new Producto();
			p.setId(resultado.getInt("idproducto"));
			p.setTipoProducto(resultado.getString("tipoProducto"));
			p.setQuantidade(resultado.getInt("quantidade"));
			lista.add(p);
		}
		
		return lista;
		
		
		
		
	}
	
}
