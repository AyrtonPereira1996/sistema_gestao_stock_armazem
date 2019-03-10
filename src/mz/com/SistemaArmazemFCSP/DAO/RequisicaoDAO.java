package mz.com.SistemaArmazemFCSP.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mz.com.SistemaArmazemFCSP.domain.Departamento;
import mz.com.SistemaArmazemFCSP.domain.Funcionario;
import mz.com.SistemaArmazemFCSP.domain.Producto;
import mz.com.SistemaArmazemFCSP.domain.Requisicao;
import mz.com.SistemaArmazemFCSP.factory.Conexao;

public class RequisicaoDAO {
	public void inserir(Requisicao r) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("insert into requisicao ");
		sql.append("(idRequisicao, idDepartamento, idFuncionario, idProducto, quantidade, data) ");
		sql.append("values(default, ?, ?, ?, ?, now())");
		
		Connection conexao = Conexao.conectar();
		
		PreparedStatement stmt = conexao.prepareStatement(sql.toString());
		stmt.setInt(1, r.getDepartamento().getIdDepartamento());
		stmt.setInt(2, r.getFuncionario().getId());
		stmt.setInt(3, r.getProducto().getId());
		stmt.setInt(4, r.getQuantidade());
		stmt.executeUpdate();
		stmt.close();
		
	}
	
	public void excluir(Requisicao r) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("delete from requisicao ");
		sql.append("where idRequisicao=?");
		
		Connection conexao = Conexao.conectar();
		PreparedStatement stmt = conexao.prepareStatement(sql.toString());
		stmt.setInt(1,r.getId());
		stmt.executeUpdate();
		stmt.close();
	}
	
	public void editar(Requisicao r) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("update requisicao ");
		sql.append("set idDepartamento=?, idFuncionario=?, idProducto=?, quantidade=? ");
		sql.append("where idRequisicao=? ");
		
		Connection conexao = Conexao.conectar();
		PreparedStatement stmt = conexao.prepareStatement(sql.toString());
		stmt.setInt(1, r.getDepartamento().getIdDepartamento());
		stmt.setInt(2, r.getFuncionario().getId());
		stmt.setInt(3, r.getProducto().getId());
		stmt.setInt(4, r.getQuantidade());
		stmt.setInt(5, r.getId());
		stmt.executeUpdate();
		stmt.close();
		
	}
	
	
	public ArrayList<Requisicao> listar() throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("select r.idrequisicao, d.nomeDepartamento, f.nome, f.apelido, p.tipoProducto, r.data, r.quantidade ");
		sql.append("from requisicao as r ");
		sql.append("inner join departamento as d on r.idDepartamento = d.idDepartamento ");
		sql.append("inner join funcionario as f on r.idFuncionario = f.idFuncionario ");
		sql.append("inner join producto as p on r.idproducto = p.idProducto ");
		sql.append("order by r.data desc ");
		
		Connection conexao = Conexao.conectar();
		PreparedStatement stmt = conexao.prepareStatement(sql.toString());
		
		ResultSet resultado = stmt.executeQuery();
		ArrayList<Requisicao> lista = new ArrayList<Requisicao>();
		
		while(resultado.next()) {
			Departamento d = new Departamento();
			d.setNomeDepartamento(resultado.getString("d.nomeDepartamento"));
			
			Funcionario f = new Funcionario();
			f.setNomeFuncionario(resultado.getString("f.nome"));
			f.setApelidoFuncionario(resultado.getString("f.apelido"));
			
			Producto p = new Producto();
			p.setTipoProducto(resultado.getString("p.tipoProducto"));
			
			Requisicao r = new Requisicao();
			r.setId(resultado.getInt("r.idrequisicao"));
			r.setDepartamento(d);
			r.setFuncionario(f);
			r.setProducto(p);
			r.setQuantidade(resultado.getInt("r.quantidade"));
			r.setDataRequisicao(resultado.getTimestamp("r.data"));
			lista.add(r);
		}
		
		return lista;
			}
	
}
