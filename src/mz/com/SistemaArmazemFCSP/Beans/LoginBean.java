package mz.com.SistemaArmazemFCSP.Beans;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
//import javax.servlet.http.HttpSession;


import mz.com.SistemaArmazemFCSP.DAO.FuncionarioDAO;
import mz.com.SistemaArmazemFCSP.DAO.LoginSysDAO;
import mz.com.SistemaArmazemFCSP.DAO.UsuarioDAO;
import mz.com.SistemaArmazemFCSP.domain.Funcionario;
import mz.com.SistemaArmazemFCSP.domain.Usuario;
import mz.com.SistemaArmazemFCSP.util.Mensagens;

@ManagedBean(name = "MBLoginBean")
@SessionScoped
public class LoginBean implements Serializable {
	private Usuario usuario = new Usuario();
	private Funcionario funcionario = new Funcionario();
	private ArrayList<Usuario> itens;
	private ArrayList<Usuario> itensListados;
	private ArrayList<Funcionario> itensFuncionario;
	ExternalContext externalContext;
	//HttpSession session;

	private static final long serialVersionUID = -31701307345516338L;


	public Funcionario getFuncionario() {
		return funcionario;
	}

	public ArrayList<Funcionario> getItensFuncionario() {
		return itensFuncionario;
	}

	public void setItensFuncionario(ArrayList<Funcionario> itensFuncionario) {
		this.itensFuncionario = itensFuncionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public ArrayList<Usuario> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Usuario> itens) {
		this.itens = itens;
	}

	public ArrayList<Usuario> getItensListados() {
		return itensListados;
	}

	public void setItensListados(ArrayList<Usuario> itensListados) {
		this.itensListados = itensListados;
	}

	public void inserir() {

		try {

			UsuarioDAO udao = new UsuarioDAO();
			udao.salvar(usuario);
			itens = udao.listar();
			Mensagens.adicionarMensagemSucesso("Salvo com sucesso!");
		} catch (SQLException e) {
			Mensagens.adicionarMensagemErro("Não é possivel registar o usuário!");
			e.printStackTrace();
		}

	}

	public void excluir() {
		UsuarioDAO udao = new UsuarioDAO();
		try {
			udao.excluir(usuario);
			itens = udao.listar();
			Mensagens.adicionarMensagemSucesso("Excluído com sucesso!");
		} catch (SQLException e) {
			Mensagens.adicionarMensagemErro("Não é possivel excluir o usuário!");
			e.printStackTrace();
		}

	}

	public void editar() {

		try {
			UsuarioDAO udao = new UsuarioDAO();
			udao.editar(usuario);
			itens = udao.listar();
			Mensagens.adicionarMensagemSucesso("Editado com sucesso!");
		} catch (SQLException ex) {
			Mensagens.adicionarMensagemErro("Não é possivel editar o usuário!");
			ex.printStackTrace();
		}
	}

	public void prepararInserir() {

		try {
			usuario = new Usuario();
			FuncionarioDAO fdao = new FuncionarioDAO();
			itensFuncionario = fdao.listar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void prepararEditar() {

		try {
			usuario = new Usuario();
			FuncionarioDAO dfao = new FuncionarioDAO();
			itensFuncionario = dfao.listar();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@PostConstruct
	public void prepararPesquisa() {

		try {
			UsuarioDAO udao = new UsuarioDAO();
			itens = udao.listar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void prepararLogin() {
		usuario = new Usuario();
	}

	public String login() {
		Usuario usuarioRetornado = null;

		UsuarioDAO udao = new UsuarioDAO();
		LoginSysDAO lsdao = new LoginSysDAO();
		
		try {
			usuarioRetornado = udao.buscarUsuario(usuario.getUsuario(), usuario.getSenha());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println(usuarioRetornado.getUsuario());

		if (usuarioRetornado.getRolestring().equalsIgnoreCase("Admin")) {
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuarioRetornado);
			Mensagens.adicionarMensagemSucesso("Login efectuado com sucesso. Bem vindo!");
			// FacesContext.getCurrentInstance().getApplication().getNavigationHandler()
			// .handleNavigation(FacesContext.getCurrentInstance(), null,
			// "indexAdmin.xhtml");

			try {
				lsdao.inserirAdmin();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return "indexAdmin.xhtml";

		} else if (usuarioRetornado.getRolestring().equalsIgnoreCase("Administrador")) {
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuarioRetornado);
			Mensagens.adicionarMensagemSucesso("Login efectuado com sucesso. Bem vindo!");
			// FacesContext.getCurrentInstance().getApplication().getNavigationHandler()
			// .handleNavigation(FacesContext.getCurrentInstance(), null,
			// "indexAdministrador.xhtml");

			try {
				lsdao.inserirAdministrador();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return "indexAdministrador.xhtml";

		} else if (usuarioRetornado.getRolestring().equalsIgnoreCase("Funcionario")) {
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuarioRetornado);
			Mensagens.adicionarMensagemSucesso("Login efectuado com sucesso. Bem vindo!");
			// FacesContext.getCurrentInstance().getApplication().getNavigationHandler()
			// .handleNavigation(FacesContext.getCurrentInstance(), null,
			// "indexFuncionario.xhtml");

			try {
				lsdao.inserirFuncionario();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "indexFuncionario.xhtml";

		} else {
			Mensagens.adicionarMensagemErro("Por favor volte a preencher para efectuar o login");
			return "index.xhtml";
		}
	}

	public String logout() {
		Usuario usuarioRetornado = new Usuario();
		FacesContext fc = FacesContext.getCurrentInstance();
		//HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		//session.invalidate();
		System.out.println("terminou" + usuarioRetornado.getUsuario());
		return "logout.xhtml";
	}

}
