package mz.com.SistemaArmazemFCSP.domain;

import java.sql.Timestamp;

public class HistorialProducto {
	
	private int idHistorial;
	private Producto producto = new Producto();
	private String descricao;
	private Timestamp dataModificacao;
	
	
	public int getIdHistorial() {
		return idHistorial;
	}

	public void setIdHistorial(int idHistorial) {
		this.idHistorial = idHistorial;
	}
	
	public Producto getProducto() {
		return producto;
	}
	
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	public Timestamp getDataModificacao() {
		return dataModificacao;
	}
	
	public void setDataModificacao(Timestamp dataModificacao) {
		this.dataModificacao = dataModificacao;
	}
	
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
