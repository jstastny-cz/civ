package cz.muni.fi.civ.newohybat.persistence.facade.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.kie.api.definition.type.PropertyReactive;

/**
 * Representation of a unit type.
 * @author newohybat
 *
 */
@PropertyReactive
public class UnitTypeDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 866499471859790148L;
	private String ident;
	private String name;
	private String description;
	private Boolean military;
	private Integer attackStrength;
	private Integer defenseStrength;
	private Integer movementPoints;
	private Set<String> actions;
	private Integer cost;
	private String obsoletedByAdvance;
	private String movementArea;
	
	public UnitTypeDTO(){
		military=false;
		attackStrength=0;
		defenseStrength=0;
		movementPoints=0;
		actions = new HashSet<String>();
		cost = 0;
	}
	
	public String getIdent() {
		return ident;
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
	public Integer getAttackStrength() {
		return attackStrength;
	}
	public void setAttackStrength(Integer attackStrength) {
		this.attackStrength = attackStrength;
	}
	public Integer getDefenseStrength() {
		return defenseStrength;
	}
	public void setDefenseStrength(Integer defenseStrength) {
		this.defenseStrength = defenseStrength;
	}
	public Integer getMovementPoints() {
		return movementPoints;
	}
	public void setMovementPoints(Integer movementPoints) {
		this.movementPoints = movementPoints;
	}
	public Boolean getMilitary() {
		return military;
	}
	public void setMilitary(Boolean military) {
		this.military = military;
	}
	public Set<String> getActions() {
		return actions;
	}
	public void setActions(Set<String> actions) {
		this.actions = actions;
	}
	public Integer getCost() {
		return cost;
	}
	public void setCost(Integer cost) {
		this.cost = cost;
	}
	public String getObsoletedByAdvance() {
		return obsoletedByAdvance;
	}
	public void setObsoletedByAdvance(String obsoletedByAdvance) {
		this.obsoletedByAdvance = obsoletedByAdvance;
	}
	public String getMovementArea() {
		return movementArea;
	}
	public void setMovementArea(String movementArea) {
		this.movementArea = movementArea;
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
		UnitTypeDTO other = (UnitTypeDTO) obj;
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
		return "UnitTypeDTO [ident=" + ident + ", name=" + name
				+ ", description=" + description + ", military=" + military
				+ ", attackStrength=" + attackStrength + ", defenseStrength="
				+ defenseStrength + ", movementPoints=" + movementPoints
				+ ", actions=" + actions + ", cost=" + cost
				+ ", obsoletedByAdvance=" + obsoletedByAdvance
				+ ", movementArea=" + movementArea + "]";
	}
	
}
