package mz.com.SistemaArmazemFCSP.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mz.com.SistemaArmazemFCSP.domain.LoginSys;
import mz.com.SistemaArmazemFCSP.factory.Conexao;

public class LoginSysDAO {
	public void inserirAdmin() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into login_sys ");
		sql.append("(usuario, descricao, dataRegisto) ");
		sql.append("values('Admin', 'Iniciou sessão', now()) ");

		Connection conexao = Conexao.conectar();
		PreparedStatement stmt = conexao.prepareStatement(sql.toString());
		stmt.executeUpdate();
		stmt.close();

	}

	public void inserirAdministrador() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into login_sys ");
		sql.append("(usuario, descricao, dataRegisto) ");
		sql.append("values('Administrador', 'Iniciou sessão', now()) ");

		Connection conexao = Conexao.conectar();
		PreparedStatement stmt = conexao.prepareStatement(sql.toString());
		stmt.executeUpdate();
		stmt.close();
	}

	public void inserirFuncionario() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into login_sys ");
		sql.append("(usuario, descricao, dataRegisto) ");
		sql.append("values('Funcionario', 'Iniciou sessão', now()) ");

		Connection conexao = Conexao.conectar();
		PreparedStatement stmt = conexao.prepareStatement(sql.toString());
		stmt.executeUpdate();
		stmt.close();
	}

	public void inserirOutAdmin() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into login_sys ");
		sql.append("(usuario, descricao, dataRegisto) ");
		sql.append("values('Admin', 'Terminou sessão', now()) ");

		Connection conexao = Conexao.conectar();
		PreparedStatement stmt = conexao.prepareStatement(sql.toString());
		stmt.executeUpdate();
		stmt.close();
	}

	public void inserirOutAdministrador() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into login_sys ");
		sql.append("(usuario, descricao, dataRegisto) ");
		sql.append("values('Administrador', 'Terminou sessão', now()) ");

		Connection conexao = Conexao.conectar();
		PreparedStatement stmt = conexao.prepareStatement(sql.toString());
		stmt.executeUpdate();
		stmt.close();
	}

	public void inserirOutFuncionario() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into login_sys ");
		sql.append("(usuario, descricao, dataRegisto) ");
		sql.append("values('Funcionário', 'Terminou sessão', now()) ");

		Connection conexao = Conexao.conectar();
		PreparedStatement stmt = conexao.prepareStatement(sql.toString());
		stmt.executeUpdate();
		stmt.close();
	}

	public ArrayList<LoginSys> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("select idLoginSys, usuario, descricao, dataRegisto from login_sys ");
		sql.append("order by dataRegisto desc ");

		Connection conexao = Conexao.conectar();
		PreparedStatement stmt = conexao.prepareStatement(sql.toString());

		ResultSet resultado = stmt.executeQuery();

		ArrayList<LoginSys> lista = new ArrayList<LoginSys>();
		while (resultado.next()) {
			LoginSys ls = new LoginSys();
			ls.setId(resultado.getInt("idLoginSys"));
			ls.setUsuario(resultado.getString("usuario"));
			ls.setDescricao(resultado.getString("descricao"));
			ls.setData(resultado.getTimestamp("dataRegisto"));
			lista.add(ls);
		}
		return lista;

	}
}
