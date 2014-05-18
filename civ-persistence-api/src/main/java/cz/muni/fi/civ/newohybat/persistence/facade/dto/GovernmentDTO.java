package cz.muni.fi.civ.newohybat.persistence.facade.dto;

import java.io.Serializable;

/**
 * Class represents type of government which can be established by a player.
 * @author newohybat
 *
 */
public class GovernmentDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2349884493751019404L;
	private String ident;
	private String name;
	private String description;
	
	public String getIdent() {
		return ident;
	}
	public void setIdent(String ident) {
		if(this.ident!=null) throw new IllegalStateException("Attempt to change unchangeable property.");
		this.ident = ident;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ident == null) ? 0 : ident.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GovernmentDTO other = (GovernmentDTO) obj;
		if (ident == null) {
			if (other.ident != null)
				return false;
		} else if (!ident.equals(other.ident))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GovernmentDTO [ident=" + ident + ", name=" + name
				+ ", description=" + description + "]";
	}
	
	
	
}
