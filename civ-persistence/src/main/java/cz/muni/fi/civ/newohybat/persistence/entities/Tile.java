package cz.muni.fi.civ.newohybat.persistence.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: Tile
 *
 */
@Entity

public class Tile implements Serializable {

	   
	@Id
	@GeneratedValue
	private Long id;
	private Long posX;
	private Long posY;
	@ManyToOne
	private Terrain terrain;
	@ManyToOne
	private Special special;
	@ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
        name="TILE_TILE_IMPROVEMENTS",
        joinColumns={@JoinColumn(name="TILE_ID", referencedColumnName="ID")},
        inverseJoinColumns={@JoinColumn(name="TILE_IMPROVEMENT_IDENT", referencedColumnName="IDENT")})
	private Set<TileImprovement> improvements;
//	@OneToMany(mappedBy="tile",fetch=FetchType.EAGER,cascade=CascadeType.REMOVE)
//	private Set<Unit> units;
//	@OneToOne(mappedBy = "cityCentre",cascade=CascadeType.REMOVE)
//	private City city;
	private Integer foodProduction;
	private Integer resourcesProduction;
	private Integer tradeProduction;
	private Integer movementCost;
	private Integer defenseBonus;
	private static final long serialVersionUID = 1L;

	public Tile() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public Long getPosX() {
		return this.posX;
	}

	public void setPosX(Long posX) {
		this.posX = posX;
	}   
	public Long getPosY() {
		return this.posY;
	}

	public void setPosY(Long posY) {
		this.posY = posY;
	}   
	public Terrain getTerrain() {
		return this.terrain;
	}

	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}   
	public Special getSpecial() {
		return this.special;
	}

	public void setSpecial(Special special) {
		this.special = special;
	}   
	public Set<TileImprovement> getImprovements() {
		return improvements;
	}
	public void setImprovements(Set<TileImprovement> improvements) {
		this.improvements = improvements;
	}
//	public Set<Unit> getUnits() {
//		return units;
//	}
//	public void setUnits(Set<Unit> units) {
//		this.units = units;
//	}
//	public City getCity() {
//		return city;
//	}
//	public void setCity(City city) {
//		this.city = city;
//	}

	public Integer getFoodProduction() {
		return foodProduction;
	}
	public void setFoodProduction(Integer foodProduction) {
		this.foodProduction = foodProduction;
	}
	public Integer getResourcesProduction() {
		return resourcesProduction;
	}
	public void setResourcesProduction(Integer resourcesProduction) {
		this.resourcesProduction = resourcesProduction;
	}
	public Integer getTradeProduction() {
		return tradeProduction;
	}
	public void setTradeProduction(Integer tradeProduction) {
		this.tradeProduction = tradeProduction;
	}
	public Integer getMovementCost() {
		return movementCost;
	}
	public void setMovementCost(Integer movementCost) {
		this.movementCost = movementCost;
	}
	public Integer getDefenseBonus() {
		return defenseBonus;
	}
	public void setDefenseBonus(Integer defenseBonus) {
		this.defenseBonus = defenseBonus;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tile other = (Tile) obj;
		
		if (posX == null) {
			if (other.posX != null)
				return false;
		} else if (!posX.equals(other.posX))
			return false;
		if (posY == null) {
			if (other.posY != null)
				return false;
		} else if (!posY.equals(other.posY))
			return false;
		return true;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((posX == null) ? 0 : posX.hashCode());
		result = prime * result + ((posY == null) ? 0 : posY.hashCode());
		return result;
	}
}
