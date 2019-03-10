package mz.com.SistemaArmazemFCSP.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mz.com.SistemaArmazemFCSP.domain.Funcionario;
import mz.com.SistemaArmazemFCSP.domain.Usuario;
import mz.com.SistemaArmazemFCSP.factory.Conexao;

public class UsuarioDAO {
	public void salvar(Usuario u) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("Insert into usuario ");
		sql.append("(rolestring, idFuncionario, usuario, senha, data_registo) ");
		sql.append("values(?, ?, ?, ?, now() )");

		Connection conexao = Conexao.conectar();
		PreparedStatement stmt = conexao.prepareStatement(sql.toString());
		stmt.setString(1, u.getRolestring());
		stmt.setInt(2, u.getFuncionario().getId());
		stmt.setString(3, u.getUsuario());
		stmt.setString(4, u.getSenha());
		stmt.executeUpdate();
		stmt.close();

	}

	public void excluir(Usuario u) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("Delete from usuario ");
		sql.append("where idUsuario=?");

		Connection conexao = Conexao.conectar();
		PreparedStatement stmt = conexao.prepareStatement(sql.toString());
		stmt.setInt(1, u.getId());
		stmt.executeUpdate();
		stmt.close();

	}
	
	public void editar(Usuario u) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("update usuario ");
		sql.append("set rolestring=?, idFuncionario=?, usuario=?, senha=? ");
		sql.append("where idUsuario=?");
		
		Connection conexao = Conexao.conectar();
		PreparedStatement stmt = conexao.prepareStatement(sql.toString());
		stmt.setString(1, u.getRolestring());
		stmt.setInt(2, u.getFuncionario().getId());
		stmt.setString(3, u.getUsuario());
		stmt.setString(4, u.getSenha());
		stmt.setInt(5, u.getId());
		stmt.executeUpdate();
		stmt.close();
		
	}
	
	public ArrayList<Usuario> listar() throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("Select u.idUsuario, f.nome, f.apelido, u.usuario, u.senha, u.rolestring, u.data_Registo ");
		sql.append("from usuario as u ");
		sql.append("inner join funcionario as f on f.idFuncionario = u.idFuncionario ");
		sql.append("order by u.idUsuario asc ");
		
		Connection conexao = Conexao.conectar();
		PreparedStatement stmt = conexao.prepareStatement(sql.toString());
		
		ResultSet resultado = stmt.executeQuery();
		
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		
		while(resultado.next()) {
			
			Funcionario f = new Funcionario();
			f.setNomeFuncionario(resultado.getString("f.nome"));
			f.setApelidoFuncionario(resultado.getString("f.apelido"));
			
			Usuario u = new Usuario();
			u.setId(resultado.getInt("u.idUsuario"));
			u.setFuncionario(f);
			u.setUsuario(resultado.getString("u.usuario"));
			u.setSenha(resultado.getString("u.senha"));
			u.setRolestring(resultado.getString("u.rolestring"));
			u.setDataRegisto(resultado.getTimestamp("u.data_registo"));
			lista.add(u);	
		}
		
		return lista;
		
	}
	
	public Usuario buscarUsuario(String usuario, String senha) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("Select * from usuario where usuario='"+usuario+"' and senha='"+senha+"'");
		
		
		Connection conexao = Conexao.conectar();
		PreparedStatement stmt = conexao.prepareStatement(sql.toString());

		ResultSet resultado = stmt.executeQuery();
		Usuario u = new Usuario();
		if(resultado.next()) {
			u.setUsuario(resultado.getString("usuario"));
			u.setRolestring(resultado.getString("rolestring"));
		}
		
		return u;
		
	}

}
