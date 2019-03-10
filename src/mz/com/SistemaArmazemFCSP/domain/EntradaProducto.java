package mz.com.SistemaArmazemFCSP.domain;


import java.sql.Timestamp;

public class EntradaProducto {
	private int idEntrada;
	private Producto producto = new Producto();
	private Timestamp dataEntrada;
	private int quantidade_entrada;
	private String descricao;

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Timestamp getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Timestamp dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public int getIdEntrada() {
		return idEntrada;
	}

	public void setIdEntrada(int idEntrada) {
		this.idEntrada = idEntrada;
	}

	public int getQuantidade_entrada() {
		return quantidade_entrada;
	}

	public void setQuantidade_entrada(int quantidade_entrada) {
		this.quantidade_entrada = quantidade_entrada;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		String saida = idEntrada + " " + producto + " " + dataEntrada + " " + quantidade_entrada + " " + descricao;
		return saida;
	}

}
