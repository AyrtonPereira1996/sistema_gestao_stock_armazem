package mz.com.SistemaArmazemFCSP.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mz.com.SistemaArmazemFCSP.domain.EntradaProducto;
import mz.com.SistemaArmazemFCSP.domain.Producto;
import mz.com.SistemaArmazemFCSP.factory.Conexao;

public class EntradaProductoDAO {
	public ArrayList<EntradaProducto> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("select e.identrada, p.tipoproducto, e.dataentrada, e.quantidade_entrada, e.descricao ");
		sql.append("from entrada_Producto as e ");
		sql.append("inner join producto as p on e.idProducto = p.idProducto ");
		sql.append("order by e.dataentrada desc");

		Connection conexao = Conexao.conectar();
		PreparedStatement stmt = conexao.prepareStatement(sql.toString());

		ResultSet resultado = stmt.executeQuery();

		ArrayList<EntradaProducto> lista = new ArrayList<EntradaProducto>();
		while(resultado.next()) {
			Producto p = new Producto();
			p.setTipoProducto(resultado.getString("p.tipoProducto"));
			
			EntradaProducto ep = new EntradaProducto();
			ep.setIdEntrada(resultado.getInt("e.idEntrada"));
			ep.setProducto(p);
			ep.setDataEntrada(resultado.getTimestamp("e.dataEntrada"));
			ep.setQuantidade_entrada(resultado.getInt("e.quantidade_Entrada"));
			ep.setDescricao(resultado.getString("e.descricao"));
			lista.add(ep);
		}
		
		return lista;
	}

}
