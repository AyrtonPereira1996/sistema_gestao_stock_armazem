package mz.com.SistemaArmazemFCSP.domain;


import java.sql.Timestamp;


public class Requisicao {
	private int id;
	private Departamento departamento = new Departamento();
	private Funcionario funcionario = new Funcionario();
	private Producto producto = new Producto();
	private Timestamp dataRequisicao;
	private int quantidade;

	public Timestamp getDataRequisicao() {
		return dataRequisicao;
	}
	
	public void setDataRequisicao(Timestamp dataRequisicao) {
		this.dataRequisicao = dataRequisicao;
	}
	
	public Producto getProducto() {
		return producto;
	}
	
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}


}
