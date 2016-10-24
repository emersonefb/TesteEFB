package br.com.efb.controller.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Modulo database table.
 * 
 */
@Entity
@Table(name="tblModulo")
@NamedQuery(name="Modulo.findAll", query="SELECT t FROM Modulo t")
public class Modulo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long cvIDModulo;

	private String ccNomModulo;

	public Modulo() {
	}

	public long getCvIDModulo() {
		return this.cvIDModulo;
	}

	public void setCvIDModulo(long cvIDModulo) {
		this.cvIDModulo = cvIDModulo;
	}

	public String getCcNomModulo() {
		return this.ccNomModulo;
	}

	public void setCcNomModulo(String ccNomModulo) {
		this.ccNomModulo = ccNomModulo;
	}

}