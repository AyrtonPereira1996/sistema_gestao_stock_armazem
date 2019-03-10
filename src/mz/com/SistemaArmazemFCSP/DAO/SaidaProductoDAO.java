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
import mz.com.SistemaArmazemFCSP.domain.SaidaProducto;
import mz.com.SistemaArmazemFCSP.factory.Conexao;

public class SaidaProductoDAO {
	public ArrayList<SaidaProducto> listar() throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("select s.idSaida, r.idRequisicao, d.nomeDepartamento, f.nome, f.apelido, p.tipoProducto, s.dataSaida, s.quantidade_saida, s.descricao ");
		sql.append("from saida_producto as s ");
		sql.append("inner join requisicao as r on s.idRequisicao = r.idRequisicao ");
		sql.append("inner join departamento as d on s.idDepartamento = d.idDepartamento ");
		sql.append("inner join funcionario as f on f.idFuncionario = r.idFuncionario ");
		sql.append("inner join producto as p on s.idProducto = p.idProducto ");
		sql.append("order by s.dataSaida desc ");
		
		Connection conexao = Conexao.conectar();
		PreparedStatement stmt = conexao.prepareStatement(sql.toString());
		
		ResultSet resultado = stmt.executeQuery();
		ArrayList<SaidaProducto> lista = new ArrayList<SaidaProducto>();
		
		while(resultado.next()) {
			Requisicao r = new Requisicao();
			r.setId(resultado.getInt("r.idRequisicao"));
			
			Departamento d = new Departamento();
			d.setNomeDepartamento(resultado.getString("d.nomeDepartamento"));
			
			Funcionario f = new Funcionario();
			f.setNomeFuncionario(resultado.getString("f.nome"));
			f.setApelidoFuncionario(resultado.getString("f.apelido"));
			
			Producto p = new Producto();
			p.setTipoProducto(resultado.getString("p.tipoProducto"));
			
			SaidaProducto sp = new SaidaProducto();
			sp.setIdSaida(resultado.getInt("s.idSaida"));
			sp.setRequisicao(r);
			sp.setDepartamento(d);
			sp.setProducto(p);
			sp.setFuncionario(f);
			sp.setDataSaida(resultado.getTimestamp("s.dataSaida"));
			sp.setQuantidadeSaida(resultado.getInt("s.quantidade_saida"));
			sp.setDescricao(resultado.getString("s.descricao"));
			lista.add(sp);		}
		
		return lista;
	
	}

}
