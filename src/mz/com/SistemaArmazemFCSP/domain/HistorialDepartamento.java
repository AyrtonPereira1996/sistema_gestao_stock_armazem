package mz.com.SistemaArmazemFCSP.domain;

import java.sql.Timestamp;

public class HistorialDepartamento {
	private int idHistorialDepartamento;
	private Departamento departamento = new Departamento();
	private String descricao;
	private Timestamp dataModificacao;

	

	public int getIdHistorialDepartamento() {
		return idHistorialDepartamento;
	}

	public void setIdHistorialDepartamento(int idHistorialDepartamento) {
		this.idHistorialDepartamento = idHistorialDepartamento;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Timestamp getDataModificacao() {
		return dataModificacao;
	}

	public void setDataModificacao(Timestamp dataModificacao) {
		this.dataModificacao = dataModificacao;
	}
}
