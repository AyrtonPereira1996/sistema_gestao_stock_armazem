package mz.com.SistemaArmazemFCSP.domain;

import java.sql.Timestamp;

public class HistorialFuncionario {
	private int idHistorialFuncionario;
	private Funcionario funcionario = new Funcionario();
	private String descricao;
	private Timestamp dataModificacao;
	private Departamento departamento;
	
	
	public int getIdHistorialFuncionario() {
		return idHistorialFuncionario;
	}
	
	public void setIdHistorialFuncionario(int idHistorialFuncionario) {
		this.idHistorialFuncionario = idHistorialFuncionario;
	}
	
	public Timestamp getDataModificacao() {
		return dataModificacao;
	}
	
	public void setDataModificacao(Timestamp dataModificacao) {
		this.dataModificacao = dataModificacao;
	}
	
	public Funcionario getFuncionario() {
		return funcionario;
	}
	
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Departamento getDepartamento() {
		return departamento;
	}
	
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	
	
}
