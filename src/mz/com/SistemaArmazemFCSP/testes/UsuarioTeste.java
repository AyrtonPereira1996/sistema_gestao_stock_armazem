package mz.com.SistemaArmazemFCSP.testes;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import mz.com.SistemaArmazemFCSP.DAO.UsuarioDAO;
import mz.com.SistemaArmazemFCSP.domain.Funcionario;
import mz.com.SistemaArmazemFCSP.domain.Role;
import mz.com.SistemaArmazemFCSP.domain.Usuario;

public class UsuarioTeste {
	
	@Test
	@Ignore
	public void inserir() throws SQLException{
		Funcionario f = new Funcionario();
		f.setId(14);
		Role r = new Role();
		r.setDescricao("teste");
		
		Usuario u = new Usuario();
		u.setRolestring("admin");;
		u.setFuncionario(f);
		u.setUsuario("Francisco");
		u.setSenha("12345");
		
		UsuarioDAO udao = new UsuarioDAO();
		udao.salvar(u);
		
	}
	
	@Test
	@Ignore
	public void excluir() throws SQLException{
		Usuario u = new Usuario();
		u.setId(3);
		
		UsuarioDAO udao = new UsuarioDAO();
		udao.excluir(u);
	}
	
	@Test
	@Ignore
	public void editar() throws SQLException{
		Funcionario f = new Funcionario();
		f.setId(14);
		
		Role r = new Role();
		r.setDescricao("teste");
		r.setId(4);
		
		Usuario u = new Usuario();
		u.setId(4);
		u.setRolestring("admin");;
		u.setUsuario("Franciscoo");
		u.setSenha("123455");
		u.setFuncionario(f);
		
		UsuarioDAO udao = new UsuarioDAO();
		udao.editar(u);
	}
	
	@Test
	public void listar() throws SQLException {
		UsuarioDAO udao = new UsuarioDAO();
		ArrayList<Usuario> lista = udao.listar();
		for(Usuario u : lista) {
			System.out.println("Codigo usuario: " + u.getId() );
			System.out.println("Nivel de acesso: " + u.getRolestring());
			System.out.println("Nome de funcionario: " + u.getFuncionario().getNomeFuncionario() + " " + u.getFuncionario().getApelidoFuncionario());
			System.out.println("Usuario: " + u.getUsuario());
			System.out.println("Senha: " + u.getSenha());
			System.out.println("Data: " + u.getDataRegisto());
			System.out.println(" ");
			
		}
	}
	
	
	
	
}
