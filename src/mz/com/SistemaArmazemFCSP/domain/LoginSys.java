package mz.com.SistemaArmazemFCSP.domain;

import java.sql.Timestamp;



public class LoginSys {
	private int id;
	private String usuario;
	private String descricao;
	private Timestamp data;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Timestamp getData() {
		return data;
	}
	
	public void setData(Timestamp data) {
		this.data = data;
	}
	
}
