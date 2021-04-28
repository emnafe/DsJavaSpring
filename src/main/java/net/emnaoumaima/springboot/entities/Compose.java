package net.emnaoumaima.springboot.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "compose", catalog = "examenjee")
public class Compose implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6343534664671935137L;
	private ComposeId id;

	public Compose() {
	}

	public Compose(ComposeId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "ticket", column = @Column(name = "ticket", nullable = false)),
			@AttributeOverride(name = "met", column = @Column(name = "met", nullable = false, length = 30)) })
	public ComposeId getId() {
		return this.id;
	}

	public void setId(ComposeId id) {
		this.id = id;
	}

}
