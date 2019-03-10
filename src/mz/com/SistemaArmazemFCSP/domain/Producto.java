package mz.com.SistemaArmazemFCSP.domain;


import java.sql.Timestamp;


public class Producto {
	private int id;
	private String artigo;
	private Timestamp dataRegisto;
	private String validade;
	private String tipoProducto;
	private String descricao;
	private int quantidade;
	
	public Timestamp getDataRegisto() {
		return dataRegisto;
	}
	
	public void setDataRegisto(Timestamp dataRegisto) {
		this.dataRegisto = dataRegisto;
	}
	
	public String getValidade() {
		return validade;
	}
	
	public void setValidade(String validade) {
		this.validade = validade;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getArtigo() {
		return artigo;
	}

	public void setArtigo(String artigo) {
		this.artigo = artigo;

	}

	public String getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}
