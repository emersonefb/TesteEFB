package br.com.efb.controller.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the GrupoUsuarios database table.
 * 
 */
@Entity
@Table(name="tblGrupoUsuarios")
@NamedQuery(name="GrupoUsuario.findAll", query="SELECT t FROM GrupoUsuario t")
public class GrupoUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long cvIDGrupoUsu;

	private String ccNomGrupo;

	//bi-directional many-to-one association to Usuario
//	@OneToMany(mappedBy="GrupoUsuario")
//	private List<Usuario> Usuarios;

	public GrupoUsuario() {
	}

	public long getCvIDGrupoUsu() {
		return this.cvIDGrupoUsu;
	}

	public void setCvIDGrupoUsu(long cvIDGrupoUsu) {
		this.cvIDGrupoUsu = cvIDGrupoUsu;
	}

	public String getCcNomGrupo() {
		return this.ccNomGrupo;
	}

	public void setCcNomGrupo(String ccNomGrupo) {
		this.ccNomGrupo = ccNomGrupo;
	}

//	public List<Usuario> getUsuarios() {
//		return this.Usuarios;
//	}
//
//	public void setUsuarios(List<Usuario> Usuarios) {
//		this.Usuarios = Usuarios;
//	}

//	public Usuario addUsuario(Usuario Usuario) {
//		getUsuarios().add(Usuario);
//		Usuario.setGrupoUsuario(this);
//
//		return Usuario;
//	}

//	public Usuario removeUsuario(Usuario Usuario) {
//		getUsuarios().remove(Usuario);
//		Usuario.setGrupoUsuario(null);
//
//		return Usuario;
//	}

}