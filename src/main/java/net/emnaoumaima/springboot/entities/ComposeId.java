package net.emnaoumaima.springboot.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ComposeId implements java.io.Serializable {

	private int ticket;
	private String met;

	public ComposeId() {
	}

	public ComposeId(int ticket, String met) {
		this.ticket = ticket;
		this.met = met;
	}

	@Column(name = "ticket", nullable = false)
	public int getTicket() {
		return this.ticket;
	}

	public void setTicket(int ticket) {
		this.ticket = ticket;
	}

	@Column(name = "met", nullable = false, length = 30)
	public String getMet() {
		return this.met;
	}

	public void setMet(String met) {
		this.met = met;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ComposeId))
			return false;
		ComposeId castOther = (ComposeId) other;

		return (this.getTicket() == castOther.getTicket()) && ((this.getMet() == castOther.getMet())
				|| (this.getMet() != null && castOther.getMet() != null && this.getMet().equals(castOther.getMet())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getTicket();
		result = 37 * result + (getMet() == null ? 0 : this.getMet().hashCode());
		return result;
	}

}
