package mz.com.SistemaArmazemFCSP.domain;

import java.sql.Timestamp;

public class SaidaProducto {
	private int idSaida;
	private Requisicao requisicao;
	private Departamento departamento;
	private Producto producto;
	private Funcionario funcionario;
	private Timestamp dataSaida;
	private int quantidadeSaida;
	private String descricao;
	
	public Funcionario getFuncionario() {
		return funcionario;
	}
	
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Timestamp getDataSaida() {
		return dataSaida;
	}
	
	public void setDataSaida(Timestamp dataSaida) {
		this.dataSaida = dataSaida;
	}
	
	public Departamento getDepartamento() {
		return departamento;
	}
	
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	public Producto getProducto() {
		return producto;
	}
	
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	public Requisicao getRequisicao() {
		return requisicao;
	}
	
	public void setRequisicao(Requisicao requisicao) {
		this.requisicao = requisicao;
	}
	
	public int getIdSaida() {
		return idSaida;
	}

	public void setIdSaida(int idSaida) {
		this.idSaida = idSaida;
	}


	public int getQuantidadeSaida() {
		return quantidadeSaida;
	}

	public void setQuantidadeSaida(int quantidadeSaida) {
		this.quantidadeSaida = quantidadeSaida;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		String saida = idSaida + " " + requisicao + " " + departamento + " " + producto + " " + dataSaida + " "
				+ quantidadeSaida + " " + descricao;
		return saida;
	}
}
