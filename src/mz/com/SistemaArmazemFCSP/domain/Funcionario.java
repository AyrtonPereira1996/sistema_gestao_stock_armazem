package mz.com.SistemaArmazemFCSP.domain;


import java.sql.Timestamp;

public class Funcionario {
	private int id;
	private Departamento departamento = new Departamento();
	private String nomeFuncionario;
	private String apelidoFuncionario;
	private String sexoFuncionario;
	private String cargoFuncionario;
	private String enderecoElectronico;
	private String contacto;
	private Timestamp dataRegisto;
	
	public Timestamp getDataRegisto() {
		return dataRegisto;
	}
	
	public void setDataRegisto(Timestamp dataRegisto) {
		this.dataRegisto = dataRegisto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeFuncionario() {
		return nomeFuncionario;
	}

	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}

	public String getApelidoFuncionario() {
		return apelidoFuncionario;
	}

	public void setApelidoFuncionario(String apelidoFuncionario) {
		this.apelidoFuncionario = apelidoFuncionario;
	}

	public String getSexoFuncionario() {
		return sexoFuncionario;
	}

	public void setSexoFuncionario(String sexoFuncionario) {
		this.sexoFuncionario = sexoFuncionario;
	}

	public String getCargoFuncionario() {
		return cargoFuncionario;
	}

	public void setCargoFuncionario(String cargoFuncionario) {
		this.cargoFuncionario = cargoFuncionario;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public String getEnderecoElectronico() {
		return enderecoElectronico;
	}

	public void setEnderecoElectronico(String enderecoElectronico) {
		this.enderecoElectronico = enderecoElectronico;
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
	
	

}
