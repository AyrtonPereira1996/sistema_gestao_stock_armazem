package mz.com.SistemaArmazemFCSP.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mz.com.SistemaArmazemFCSP.domain.Departamento;
import mz.com.SistemaArmazemFCSP.domain.HistorialDepartamento;
import mz.com.SistemaArmazemFCSP.factory.Conexao;

public class HistorialDepartamentoDAO {
	
	public ArrayList<HistorialDepartamento> listar() throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("select h.idHistorialDepartamento, d.codDepartamento, d.nomeDepartamento, h.descricao, d.dataRegisto, h.dataModificacao ");
		sql.append("from historial_departamento as h ");
		sql.append("inner join departamento as d on h.idDepartamento = d.idDepartamento ");
		sql.append("order by h.dataModificacao");
		
		Connection conexao = Conexao.conectar();
		
		PreparedStatement stmt = conexao.prepareStatement(sql.toString());
		ResultSet resultado = stmt.executeQuery();
		
		ArrayList<HistorialDepartamento> lista = new ArrayList<HistorialDepartamento>();
		
		while(resultado.next()) {
			Departamento d = new Departamento();
			d.setCodDepartamento(resultado.getString("d.codDepartamento"));
			d.setNomeDepartamento(resultado.getString("d.nomeDepartamento"));
			d.setDataRegisto(resultado.getTimestamp("d.dataRegisto"));
			
			HistorialDepartamento h = new HistorialDepartamento();
			h.setIdHistorialDepartamento(resultado.getInt("h.idHistorialDepartamento"));
			h.setDataModificacao(resultado.getTimestamp("h.dataModificacao"));
			h.setDescricao(resultado.getString("h.descricao"));
			h.setDepartamento(d);
			lista.add(h);
		}
		return lista;
	}

}
