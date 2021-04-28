package net.emnaoumaima.springboot.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "type_table", catalog = "examenjee")
public class TypeTable implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String type;
	private Double supplement;

	public TypeTable() {
	}

	public TypeTable(String type) {
		this.type = type;
	}

	public TypeTable(String type, Double supplement) {
		this.type = type;
		this.supplement = supplement;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "type", unique = true, nullable = false, length = 30)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "supplement", precision = 22, scale = 0)
	public Double getSupplement() {
		return this.supplement;
	}

	public void setSupplement(Double supplement) {
		this.supplement = supplement;
	}

}
