package mz.com.SistemaArmazemFCSP.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import mz.com.SistemaArmazemFCSP.domain.*;
import mz.com.SistemaArmazemFCSP.factory.Conexao;

public class HistorialFuncionarioDAO {
	public ArrayList<HistorialFuncionario> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append(
				"select h.idHistorialFuncionario, f.nome, f.apelido, f.cargo, d.nomeDepartamento, h.descricao, f.dataRegisto, h.dataModificacao ");
		sql.append("from historial_funcionario as h ");
		sql.append("inner join funcionario as f on h.idfuncionario = f.idfuncionario ");
		sql.append("inner join departamento as d on h.idDepartamento = d.idDepartamento ");
		sql.append("order by h.dataModificacao desc ");

		Connection conexao = Conexao.conectar();

		PreparedStatement stmt = conexao.prepareStatement(sql.toString());
		ResultSet resultado = stmt.executeQuery();

		ArrayList<HistorialFuncionario> lista = new ArrayList<HistorialFuncionario>();

		while (resultado.next()) {
			Funcionario f = new Funcionario();
			f.setNomeFuncionario(resultado.getString("f.nome"));
			f.setApelidoFuncionario(resultado.getString("f.apelido"));
			f.setCargoFuncionario(resultado.getString("f.cargo"));
			f.setDataRegisto(resultado.getTimestamp("f.dataRegisto"));

			Departamento d = new Departamento();
			d.setNomeDepartamento(resultado.getString("d.nomeDepartamento"));

			HistorialFuncionario h = new HistorialFuncionario();
			h.setIdHistorialFuncionario(resultado.getInt("h.idHistorialFuncionario"));
			h.setDataModificacao(resultado.getTimestamp("h.dataModificacao"));
			h.setDescricao(resultado.getString("h.descricao"));
			h.setFuncionario(f);
			h.setDepartamento(d);
			lista.add(h);
		}

		return lista;
	}
}
