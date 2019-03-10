package mz.com.SistemaArmazemFCSP.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mz.com.SistemaArmazemFCSP.domain.Departamento;
import mz.com.SistemaArmazemFCSP.factory.Conexao;

public class DepartamentoDAO {
	public void inserir(Departamento d) throws SQLException { // Metodo quem permitira a inserção de dados na tabela
																// departamento
		StringBuilder sql = new StringBuilder();
		sql.append("insert into departamento ");
		sql.append("(codDepartamento, nomeDepartamento, nomeCoordenador, dataRegisto) ");
		sql.append("values(?, ?, ?, now()) ");

		Connection conexao = Conexao.conectar();

		PreparedStatement stmt = conexao.prepareStatement(sql.toString());
		stmt.setString(1, d.getCodDepartamento());
		stmt.setString(2, d.getNomeDepartamento());
		stmt.setString(3, d.getNomeCoordenador());
		stmt.executeUpdate();
		stmt.close();
	}

	public void excluir(Departamento d) throws SQLException { // metodo que permitira a exclusao dos registos da tabela
																// departamento
		StringBuilder sql = new StringBuilder();
		sql.append("delete from departamento ");
		sql.append("where codDepartamento= ?");

		Connection conexao = Conexao.conectar();
		PreparedStatement stmt = conexao.prepareStatement(sql.toString());
		stmt.setString(1, d.getCodDepartamento());
		stmt.executeUpdate();
		stmt.close();

	}

	public void editar(Departamento d) throws SQLException { // metodo que permitira editar registos na table
																// departamento
		StringBuilder sql = new StringBuilder();
		sql.append("Update departamento ");
		sql.append("set codDepartamento=?, nomeDepartamento=?, nomeCoordenador=? ");
		sql.append("where codDepartamento=?");

		Connection conexao = Conexao.conectar();

		PreparedStatement stmt = conexao.prepareStatement(sql.toString());
		stmt.setString(1, d.getCodDepartamento());
		stmt.setString(2, d.getNomeDepartamento());
		stmt.setString(3, d.getNomeCoordenador());
		stmt.setString(4, d.getCodDepartamento());
		stmt.executeUpdate();
		stmt.close();
	}

	public Departamento pesquisaPorCodigo(Departamento d) throws SQLException { // Metodo que permite pesquisar na
																				// tabela departmaneto pelo codigo
		StringBuilder sql = new StringBuilder();
		sql.append("select codDepartamento, nomeDepartamento, nomeCoordenador ");
		sql.append("from departamento ");
		sql.append("where codDepartamento=? ");

		Connection conexao = Conexao.conectar();

		PreparedStatement stmt = conexao.prepareStatement(sql.toString());
		stmt.setString(1, d.getCodDepartamento());

		ResultSet resultado = stmt.executeQuery();

		Departamento retorno = null;

		if (resultado.next()) {
			retorno = new Departamento();
			retorno.setCodDepartamento(resultado.getString("codDepartamento"));
			retorno.setNomeDepartamento(resultado.getString("nomeDepartamento"));
			retorno.setNomeCoordenador(resultado.getString("nomeCoordenador"));
		}
		return retorno;
	}

	public ArrayList<Departamento> listar() throws SQLException {// Metodo que permite listar os registos que se
																	// encontram armazenados na tabela Departamento
		StringBuilder sql = new StringBuilder();
		sql.append("Select idDepartamento, codDepartamento, nomeDepartamento, nomeCoordenador, dataRegisto ");
		sql.append("from Departamento ");
		sql.append("order by idDepartamento asc ");

		Connection conexao = Conexao.conectar();

		PreparedStatement stmt = conexao.prepareStatement(sql.toString());

		ResultSet resultado = stmt.executeQuery();

		ArrayList<Departamento> lista = new ArrayList<Departamento>();

		while (resultado.next()) {
			Departamento d = new Departamento();
			d.setIdDepartamento(resultado.getInt("idDepartamento"));
			d.setCodDepartamento(resultado.getString("codDepartamento"));
			d.setNomeDepartamento(resultado.getString("nomeDepartamento"));
			d.setNomeCoordenador(resultado.getString("nomeCoordenador"));
			d.setDataRegisto(resultado.getTimestamp("dataRegisto"));
			lista.add(d);
		}

		return lista;

	}
}

	