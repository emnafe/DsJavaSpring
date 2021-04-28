package net.emnaoumaima.springboot.entities;


import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "ticket", catalog = "examenjee")
public class Ticket implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long numero;
	
	
	private Date date;
	private int nbCouvert;
	private Long addition;
	private Integer tableclient;
	private Integer client;

	public Ticket() {
	}

	public Ticket(int numero, Date date, int nbCouvert) {
		this.numero = numero;
		this.date = date;
		this.nbCouvert = nbCouvert;
	}

	public Ticket(int numero, Date date, int nbCouvert, Long addition, Integer tableclient, Integer client) {
		this.numero = numero;
		this.date = date;
		this.nbCouvert = nbCouvert;
		this.addition = addition;
		this.tableclient = tableclient;
		this.client = client;
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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date", nullable = false, length = 19)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "nbCouvert", nullable = false)
	public int getNbCouvert() {
		return this.nbCouvert;
	}

	public void setNbCouvert(int nbCouvert) {
		this.nbCouvert = nbCouvert;
	}

	@Column(name = "addition", precision = 10, scale = 0)
	public Long getAddition() {
		return this.addition;
	}

	public void setAddition(Long addition) {
		this.addition = addition;
	}

	@Column(name = "tableclient")
	public Integer getTableclient() {
		return this.tableclient;
	}

	public void setTableclient(Integer tableclient) {
		this.tableclient = tableclient;
	}

	@Column(name = "client")
	public Integer getClient() {
		return this.client;
	}

	public void setClient(Integer client) {
		this.client = client;
	}
	

	
	@ManyToMany(mappedBy = "employees", cascade = CascadeType.REMOVE)
	List<Met> mets;
	
	@ManyToOne
	@JsonIgnore
	private TableClient tableClient;
	private Client numeroclient;


}
