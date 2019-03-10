package mz.com.SistemaArmazemFCSP.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mz.com.SistemaArmazemFCSP.domain.HistorialProducto;
import mz.com.SistemaArmazemFCSP.domain.Producto;
import mz.com.SistemaArmazemFCSP.factory.Conexao;

public class HistorialProductoDAO {
	
	public ArrayList<HistorialProducto> listar() throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("select h.idHistorial_producto, p.tipoProducto, h.descricao, p.data, h.dataModificacao ");
		sql.append("from historial_Producto as h ");
		sql.append("inner join producto as p on h.idProducto = p.idProducto ");
		sql.append("order by h.dataModificacao");
		
		Connection conexao = Conexao.conectar();
		
		PreparedStatement stmt = conexao.prepareStatement(sql.toString());
		
		ResultSet resultado = stmt.executeQuery();
		
		ArrayList<HistorialProducto> lista = new ArrayList<HistorialProducto>();
		
		while (resultado.next()) {
			Producto p = new Producto();
			p.setDataRegisto(resultado.getTimestamp("p.data"));
			p.setTipoProducto(resultado.getString("p.tipoProducto"));
			
			
			HistorialProducto hp = new HistorialProducto();
			hp.setIdHistorial(resultado.getInt("h.idHistorial_producto"));
			hp.setDescricao(resultado.getString("h.descricao"));
			hp.setDataModificacao(resultado.getTimestamp("h.dataModificacao"));
			hp.setProducto(p);
			lista.add(hp);
					
		}
		
		return lista;
		
	}

}
