package mz.com.SistemaArmazemFCSP.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Usuario implements Serializable {
	

	private static final long serialVersionUID = -2641695056628096265L;
	
	private int id;
	private Funcionario funcionario = new Funcionario();
	private String usuario;
	private String senha;
	private Timestamp dataRegisto;
	private String rolestring;
	
	public Usuario() {
		
	}
	
	public Usuario(String usuario, String senha, Role role) {
		this.usuario = usuario;
		this.senha = senha;
	}
	


	public Timestamp getDataRegisto() {
		return dataRegisto;
	}
	
	public void setDataRegisto(Timestamp dataRegisto) {
		this.dataRegisto = dataRegisto;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getRolestring() {
		return rolestring;
	}

	public void setRolestring(String rolestring) {
		this.rolestring = rolestring;
	}
	
	

}
