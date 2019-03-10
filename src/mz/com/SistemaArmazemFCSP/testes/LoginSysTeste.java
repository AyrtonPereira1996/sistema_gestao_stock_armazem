package mz.com.SistemaArmazemFCSP.testes;


import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import mz.com.SistemaArmazemFCSP.DAO.LoginSysDAO;
import mz.com.SistemaArmazemFCSP.domain.LoginSys;


public class LoginSysTeste {

	@Test
	@Ignore
	public void inserirAdmin() throws SQLException {
		LoginSysDAO lsdao = new LoginSysDAO();
		lsdao.inserirAdmin();	
	}
	
	@Test
	@Ignore
	public void inserirAdministrador() throws SQLException{
		LoginSysDAO lsdao = new LoginSysDAO();
		lsdao.inserirAdministrador();
	}
	
	@Test
	@Ignore
	public void inserirFuncionario() throws SQLException{
		LoginSysDAO lsdao = new LoginSysDAO();
		lsdao.inserirFuncionario();
	}
	
	@Test
	@Ignore
	public void inserirOutAdmin() throws SQLException{
		LoginSysDAO lsdao = new LoginSysDAO();
		lsdao.inserirOutAdmin();
	}
	
	@Test
	@Ignore
	public void inserirOutAdministrador() throws SQLException{
		LoginSysDAO lsdao= new LoginSysDAO();
		lsdao.inserirOutAdministrador();
	}
	
	@Test
	@Ignore
	public void inserirOutFuncionario() throws SQLException {
		LoginSysDAO lsdao = new LoginSysDAO();
		lsdao.inserirOutFuncionario();
		
	}
	
	@Test
	public void listar() throws SQLException{
		LoginSysDAO lsdao = new LoginSysDAO();
		ArrayList<LoginSys> lista = lsdao.listar();
		
		for(LoginSys ls : lista) {
			System.out.println("Codigo de login : " + ls.getId());
			System.out.println("Usuário : " + ls.getUsuario());
			System.out.println("Descrição : " + ls.getDescricao());
			System.out.println("Data de login : " + ls.getData());
			System.out.println(" ");
			
		}
	}

	
	
	
	
}
