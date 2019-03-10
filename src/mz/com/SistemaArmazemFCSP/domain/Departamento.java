package mz.com.SistemaArmazemFCSP.domain;


import java.sql.Timestamp;

public class Departamento {
	private int idDepartamento;
	private String codDepartamento;
	private String nomeDepartamento;
	private String nomeCoordenador;
	private Timestamp dataRegisto;
	
	public Timestamp getDataRegisto() {
		return dataRegisto;
	}
	
	public void setDataRegisto(Timestamp dataRegisto) {
		this.dataRegisto = dataRegisto;
	}

	public int getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(int idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public String getCodDepartamento() {
		return codDepartamento;
	}

	public void setCodDepartamento(String codDepartamento) {
		this.codDepartamento = codDepartamento;

	}

	public String getNomeDepartamento() {
		return nomeDepartamento;
	}

	public void setNomeDepartamento(String nomeDepartamento) {
		this.nomeDepartamento = nomeDepartamento;
	}

	public String getNomeCoordenador() {
		return nomeCoordenador;
	}

	public void setNomeCoordenador(String nomeCoordenador) {
		this.nomeCoordenador = nomeCoordenador;
	}
	
	@Override
	public String toString() {
		String saida = idDepartamento + " " + codDepartamento + " " + nomeDepartamento + " " + nomeCoordenador; 
		return saida;
	}

}
