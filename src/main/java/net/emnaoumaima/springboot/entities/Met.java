package net.emnaoumaima.springboot.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "met", catalog = "examenjee")
public class Met implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nom;
	private double prix;
	private Character type;

	public Met() {
	}

	public Met(String nom, double prix) {
		this.nom = nom;
		this.prix = prix;
	}

	public Met(String nom, double prix, Character type) {
		this.nom = nom;
		this.prix = prix;
		this.type = type;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nom", unique = true, nullable = false, length = 30)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "prix", nullable = false, precision = 22, scale = 0)
	public double getPrix() {
		return this.prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	@Column(name = "type", length = 1)
	public Character getType() {
		return this.type;
	}

	public void setType(Character type) {
		this.type = type;
	}
	
	@ManyToMany
	@JoinTable(name = "composepar")
	@JsonIgnore
	private List<Ticket> tickets;

}
