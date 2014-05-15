package cz.muni.fi.civ.newohybat.persistence.facade.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.kie.api.definition.type.PropertyReactive;
@PropertyReactive
public class UnitDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8088684900493080570L;
	private Long id;
	private Set<String> actions;
	private String currentAction;
	private String type;
	private Long tile;
	private Long targetTile;
	private Long owner;
	private Integer distanceHome;
	private Integer attackStrength;
	private Integer defenseStrength;
	private Integer movementPoints;
	private Integer healthPoints;
	private Boolean veteran;
	
	public UnitDTO(){
		actions = new HashSet<String>();
		currentAction = null;
		type = null;	// required
		tile = null;	// required
		targetTile = null;
		owner = null;	// required
		distanceHome = -1;
		attackStrength = 0;
		defenseStrength = 0;
		movementPoints = 0;
		healthPoints = 0;
		veteran =false;
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Set<String> getActions() {
		return actions;
	}
	public void setActions(Set<String> actions) {
		this.actions = actions;
	}
	public String getCurrentAction() {
		return currentAction;
	}
	public void setCurrentAction(String currentAction) {
		this.currentAction = currentAction;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public Integer getHealthPoints() {
		return healthPoints;
	}
	public void setHealthPoints(Integer healthPoints) {
		this.healthPoints = healthPoints;
	}
	public Boolean getVeteran() {
		return veteran;
	}
	public void setVeteran(Boolean veteran) {
		this.veteran = veteran;
	}
	public Long getTile() {
		return tile;
	}
	public void setTile(Long tile) {
		this.tile = tile;
	}
	public Long getTargetTile() {
		return targetTile;
	}
	public void setTargetTile(Long targetTile) {
		this.targetTile = targetTile;
	}
	
	public Long getOwner() {
		return owner;
	}
	public void setOwner(Long owner) {
		this.owner = owner;
	}
	public Integer getDistanceHome() {
		return distanceHome;
	}
	public void setDistanceHome(Integer distanceHome) {
		this.distanceHome = distanceHome;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UnitDTO [id=" + id + ", actions=" + actions
				+ ", currentAction=" + currentAction + ", type=" + type
				+ ", tile=" + tile + ", targetTile=" + targetTile + ", owner="
				+ owner + ", distanceHome=" + distanceHome
				+ ", attackStrength=" + attackStrength + ", defenseStrength="
				+ defenseStrength + ", movementPoints=" + movementPoints
				+ ", healthPoints=" + healthPoints + ", veteran=" + veteran
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UnitDTO other = (UnitDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
