package net.emnaoumaima.springboot.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tableclient", catalog = "examenjee")
public class TableClient implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long numero;
	private int nbCouvert;
	private String type;

	public TableClient() {
	}

	public TableClient(int numero, int nbCouvert) {
		this.numero = numero;
		this.nbCouvert = nbCouvert;
	}

	public TableClient(int numero, int nbCouvert, String type) {
		this.numero = numero;
		this.nbCouvert = nbCouvert;
		this.type = type;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "numero", unique = true, nullable = false)
	public long getNumero() {
		return this.numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	@Column(name = "nbCouvert", nullable = false)
	public int getNbCouvert() {
		return this.nbCouvert;
	}

	public void setNbCouvert(int nbCouvert) {
		this.nbCouvert = nbCouvert;
	}

	@Column(name = "type", length = 30)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	@OneToMany(mappedBy = "numero")
	@JsonIgnore
	private Ticket ticket;
	

}
