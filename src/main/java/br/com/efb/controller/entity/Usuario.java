package br.com.efb.controller.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The persistent class for the Usuario database table.
 * 
 */
@XmlRootElement
@Entity
@Table(name="Usuario")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String cvIDUsuarios;

	private String ccEmailUsu;

	private String ccNomUsuarios;

	private String ccSenha;

	//bi-directional many-to-one association to GrupoUsuario
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="cvIDGrupoUsu")
//	private GrupoUsuario GrupoUsuario;

//	public Usuario() {
//	}

	public String getCvIDUsuarios() {
		return this.cvIDUsuarios;
	}

	public void setCvIDUsuarios(String cvIDUsuarios) {
		this.cvIDUsuarios = cvIDUsuarios;
	}

	public String getCcEmailUsu() {
		return this.ccEmailUsu;
	}

	public void setCcEmailUsu(String ccEmailUsu) {
		this.ccEmailUsu = ccEmailUsu;
	}

	public String getCcNomUsuarios() {
		return this.ccNomUsuarios;
	}

	public void setCcNomUsuarios(String ccNomUsuarios) {
		this.ccNomUsuarios = ccNomUsuarios;
	}

	public String getCcSenha() {
		return this.ccSenha;
	}

	public void setCcSenha(String ccSenha) {
		this.ccSenha = ccSenha;
	}

//	public GrupoUsuario getGrupoUsuario() {
//		return this.GrupoUsuario;
//	}

//	public void setGrupoUsuario(GrupoUsuario GrupoUsuario) {
//		this.GrupoUsuario = GrupoUsuario;
//	}

}