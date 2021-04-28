package net.emnaoumaima.springboot.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "client", catalog = "examenjee", uniqueConstraints = @UniqueConstraint(columnNames = { "nom", "prenom",
		"dateDeNaissance" }))
public class Client implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private long id;

	@Column(name = "nom", nullable = false, length = 30)
	private String nom;

	@Column(name = "prenom", nullable = false, length = 30)
	private String prenom;

	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "dateDeNaissance", nullable = false, length = 19)
	private Date dateDeNaissance;

	@Column(name = "courriel", length = 30)
	private String courriel;

	@Column(name = "telephone", length = 30)
	private String telephone;

	public Client() {
	}

	public Client(int id, String nom, String prenom, Date dateDeNaissance) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
	}

	public Client(int id, String nom, String prenom, Date dateDeNaissance, String courriel, String telephone) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
		this.courriel = courriel;
		this.telephone = telephone;
	}
	

}
