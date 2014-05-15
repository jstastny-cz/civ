package cz.muni.fi.civ.newohybat.persistence.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import cz.muni.fi.civ.newohybat.persistence.enums.MovementArea;

/**
 * Entity implementation class for Entity: Terrain
 *
 */
@Entity
public class Terrain implements Serializable { 
	@Id
	private String ident;
	private String name;
	private String description;
	@ManyToMany(fetch=FetchType.EAGER)
	private Set<Special> specials;
	@Enumerated(EnumType.STRING)
	private MovementArea movementArea;
	private static final long serialVersionUID = 1L;

	public Terrain() {
		super();
	}   

	public String getIdent() {
		return this.ident;
	}

	public void setIdent(String ident) {
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
	public Set<Special> getSpecials() {
		return specials;
	}
	public void setSpecials(Set<Special> specials) {
		this.specials = specials;
	}
	public MovementArea getMovementArea() {
		return movementArea;
	}
	public void setMovementArea(MovementArea movementArea) {
		this.movementArea = movementArea;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Terrain other = (Terrain) obj;
		if (ident == null) {
			if (other.ident != null)
				return false;
		} else if (!ident.equals(other.ident))
			return false;
		return true;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ident == null) ? 0 : ident.hashCode());
		return result;
	}

}
