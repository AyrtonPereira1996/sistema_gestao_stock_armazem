package mz.com.SistemaArmazemFCSP.phaseListener;

import java.sql.SQLException;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import mz.com.SistemaArmazemFCSP.DAO.UsuarioDAO;
import mz.com.SistemaArmazemFCSP.domain.Usuario;

public class AutorizacaoPhaseListener implements PhaseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UsuarioDAO udao = new UsuarioDAO();
	private Usuario usuario;
	private FacesContext facesContext;
	private NavigationHandler nh;

	public FacesContext getFacesContext() {
		return facesContext;
	}

	public void setFacesContext(FacesContext facesContext) {
		this.facesContext = facesContext;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public UsuarioDAO getUdao() {
		return udao;
	}

	public void setUdao(UsuarioDAO udao) {
		this.udao = udao;
	}

	public NavigationHandler getNh() {
		return nh;
	}

	public void setNh(NavigationHandler nh) {
		this.nh = nh;
	}

	@Override
	public void afterPhase(PhaseEvent event) {
		facesContext = event.getFacesContext();
		nh = facesContext.getApplication().getNavigationHandler();
		Usuario usuario = (Usuario) facesContext.getExternalContext().getSessionMap().get("usuario");

		String paginaActual = facesContext.getViewRoot().getViewId();

		if (paginaActual.contains("/pages/*")) {
			Usuario usuarioRetornado = null;
			try {
				usuarioRetornado = udao.buscarUsuario(usuario.getUsuario(), usuario.getSenha());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (usuarioRetornado == null) {
				nh.handleNavigation(getFacesContext(), null, "index.xhtml");

			} else if (usuarioRetornado.getRolestring().equalsIgnoreCase("Admin")) {

				nh.handleNavigation(getFacesContext(), null, "indexAdmin.xhtml");

			} else if (usuarioRetornado.getRolestring().equalsIgnoreCase("Administrador")) {
				nh.handleNavigation(getFacesContext(), null, "indexAdministrador.xhtml");

			} else if (usuarioRetornado.getRolestring().equalsIgnoreCase("Funcionario")) {
				nh.handleNavigation(getFacesContext(), null, "indexFuncionario.xhtml");
			}

		} if (paginaActual.contains("/pages/index.xhtml")) {
			Usuario usuarioRetornado = null;
			try {
				usuarioRetornado = udao.buscarUsuario(usuario.getUsuario(), usuario.getSenha());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (usuarioRetornado == null) {

				nh.handleNavigation(getFacesContext(), null, "/pages/index.xhtml");
			}
		}

	}

	@Override
	public void beforePhase(PhaseEvent arg0) {
		

	}

	@Override
	public PhaseId getPhaseId() {
		
		return null;
	}

}
