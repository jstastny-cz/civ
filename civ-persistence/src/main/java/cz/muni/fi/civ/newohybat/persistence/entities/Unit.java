package cz.muni.fi.civ.newohybat.persistence.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: Unit
 *
 */
@Entity
public class Unit implements Serializable {

	   
	@Id
	@GeneratedValue
	private Long id;
	@ManyToMany(fetch=FetchType.EAGER)
	private Set<Action> actions;
	@ManyToOne
	private Action currentAction;
	@ManyToOne
	private UnitType type;
	
	@ManyToOne
	private Tile tile;
	@ManyToOne
	private Tile targetTile;
	
	@ManyToOne
	private Player owner;
	private Integer distanceHome;
	private Integer attackStrength;
	private Integer defenseStrength;
	private Integer movementPoints;
	private Integer healthPoints;
	private Boolean veteran;
	
	private static final long serialVersionUID = 1L;

	public Unit() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Set<Action> getActions() {
		return actions;
	}
	public void setActions(Set<Action> actions) {
		this.actions = actions;
	}
	public UnitType getType() {
		return type;
	}
	public void setType(UnitType type) {
		this.type = type;
	}
	public Tile getTile() {
		return tile;
	}
	public void setTile(Tile tile) {
		this.tile = tile;
	}
	public Player getOwner() {
		return owner;
	}
	public void setOwner(Player owner) {
		this.owner = owner;
	}
	public Action getCurrentAction() {
		return currentAction;
	}
	public void setCurrentAction(Action currentAction) {
		this.currentAction = currentAction;
	}
	public Tile getTargetTile() {
		return targetTile;
	}
	public void setTargetTile(Tile targetTile) {
		this.targetTile = targetTile;
	}
	public Integer getDistanceHome() {
		return distanceHome;
	}
	public void setDistanceHome(Integer distanceHome) {
		this.distanceHome = distanceHome;
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
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Unit other = (Unit) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
   
}
