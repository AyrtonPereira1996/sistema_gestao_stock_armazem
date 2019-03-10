package mz.com.SistemaArmazemFCSP.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mz.com.SistemaArmazemFCSP.domain.Departamento;
import mz.com.SistemaArmazemFCSP.domain.Funcionario;
import mz.com.SistemaArmazemFCSP.factory.Conexao;

//por testar

public class FuncionarioDAO {

	public void inserir(Funcionario f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into funcionario ");
		sql.append("(idDepartamento, nome, apelido, sexo, cargo, enderecoElectronico, contacto, dataRegisto) ");
		sql.append("values(?, ?, ?, ?, ?, ?, ?, now())");

		Connection conexao = Conexao.conectar();
		PreparedStatement stmt = conexao.prepareStatement(sql.toString());
		stmt.setInt(1, f.getDepartamento().getIdDepartamento());
		stmt.setString(2, f.getNomeFuncionario());
		stmt.setString(3, f.getApelidoFuncionario());
		stmt.setString(4, f.getSexoFuncionario());
		stmt.setString(5, f.getCargoFuncionario());
		stmt.setString(6, f.getEnderecoElectronico());
		stmt.setString(7, f.getContacto());
		stmt.executeUpdate();
		stmt.close();

	}

	public void editar(Funcionario f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("update funcionario ");
		sql.append("set idDepartamento=?, nome=?, apelido=?, sexo=?, cargo=?, enderecoElectronico=?, contacto=? ");
		sql.append("where idFuncionario=?");

		Connection conexao = Conexao.conectar();
		PreparedStatement stmt = conexao.prepareStatement(sql.toString());

		stmt.setInt(1, f.getDepartamento().getIdDepartamento());
		stmt.setString(2, f.getNomeFuncionario());
		stmt.setString(3, f.getApelidoFuncionario());
		stmt.setString(4, f.getSexoFuncionario());
		stmt.setString(5, f.getCargoFuncionario());
		stmt.setString(6, f.getEnderecoElectronico());
		stmt.setString(7, f.getContacto());
		stmt.setInt(8, f.getId());
		stmt.executeUpdate();
		stmt.close();

	}

	public void excluir(Funcionario f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("delete from funcionario ");
		sql.append("where idFuncionario=? ");

		Connection conexao = Conexao.conectar();
		PreparedStatement stmt = conexao.prepareStatement(sql.toString());
		stmt.setInt(1, f.getId());
		stmt.executeUpdate();
		stmt.close();

	}

	public ArrayList<Funcionario> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("select f.idFuncionario, d.nomeDepartamento, f.nome, f.apelido, f.sexo, f.cargo, f.enderecoElectronico, f.contacto, f.dataRegisto ");
		sql.append("from funcionario as f ");
		sql.append("inner join departamento as d on d.idDepartamento = f.idDepartamento ");
		sql.append("order by f.idFuncionario asc");

		Connection conexao = Conexao.conectar();

		PreparedStatement stmt = conexao.prepareStatement(sql.toString());

		ResultSet resultado = stmt.executeQuery();

		ArrayList<Funcionario> lista = new ArrayList<Funcionario>();

		while (resultado.next()) {
			Departamento d = new Departamento();
			d.setNomeDepartamento(resultado.getString("d.nomeDepartamento"));
			
			Funcionario f = new Funcionario();
			f.setId(resultado.getInt("f.idFuncionario"));
			f.setNomeFuncionario(resultado.getString("f.nome"));
			f.setApelidoFuncionario(resultado.getString("f.apelido"));
			f.setSexoFuncionario(resultado.getString("f.sexo"));
			f.setCargoFuncionario(resultado.getString("f.cargo"));
			f.setEnderecoElectronico(resultado.getString("f.enderecoElectronico"));
			f.setContacto(resultado.getString("f.contacto"));
			f.setDataRegisto(resultado.getTimestamp("f.dataRegisto"));
			f.setDepartamento(d);
			lista.add(f);
								
		}
		
		return lista;

	}

}
