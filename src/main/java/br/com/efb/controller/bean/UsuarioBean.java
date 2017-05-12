package br.com.efb.controller.bean;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.xml.ws.Endpoint;

import br.com.efb.controller.Service.UsuarioService;
import br.com.efb.controller.entity.Usuario;
import br.com.efb.controller.xml.Gerador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@ViewScoped
public class UsuarioBean {

	@Autowired
	private UsuarioService usuarioService;

	Usuario Usuario = new Usuario();

	public void salvar()  {
//		usuarioService.salvar(Usuario);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Salvo Com Sucesso", null));
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("page2.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @return the UsuarioService
	 */
	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	/**
	 * @param UsuarioService
	 *            the UsuarioService to set
	 */
	public void setUsuarioService(UsuarioService UsuarioService) {
		this.usuarioService = UsuarioService;
	}
	
	private String usuario;
	

	@PostConstruct
	public void init() {
		List <Usuario> usos = usuarioService.listarUsuarios();
		Usuario usus = usuarioService.FindUsuarios();
//		for (Usuario usuario : usus) {
//			System.out.println(usuario.getCcNomUsuarios());
//			this.usuario = usuario.getCcNomUsuarios();
//		}
		this.usuario = usus.getCcNomUsuarios();

		System.out.println("web service - Gerador Inicializado");
		Gerador gerador = new Gerador();
		Endpoint.publish("http://localhost:8080/gerador", gerador);
	}
	
	public void busca() {
		List<Usuario> usus = usuarioService.listarUsuarios();
		for (Usuario usuario : usus) {
			this.usuario = usuario.getCcNomUsuarios();
		}
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}
