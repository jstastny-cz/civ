package cz.muni.fi.civ.newohybat.persistence.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * Entity implementation class for Entity: City
 *
 */
@Entity

public class City implements Serializable {

	   
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
	        name="CITY_CITY_IMPROVEMENTS",
	        joinColumns={@JoinColumn(name="CITY_ID", referencedColumnName="ID")},
	        inverseJoinColumns={@JoinColumn(name="CITY_IMPROVEMENT_IDENT", referencedColumnName="IDENT")})
	private Set<CityImprovement> improvements;
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
	        name="CITY_ENABLED_CITY_IMPROVEMENTS",
	        joinColumns={@JoinColumn(name="CITY_ID", referencedColumnName="ID")},
	        inverseJoinColumns={@JoinColumn(name="CITY_IMPROVEMENT_IDENT", referencedColumnName="IDENT")})
	private Set<CityImprovement> enabledImprovements;
	
	@ManyToOne
	private CityImprovement currentImprovement;
	@ManyToOne
	private UnitType currentUnit;
	@OneToMany(fetch=FetchType.EAGER)
	private Set<Unit> homeUnits;
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
	        name="CITY_ENABLED_UNIT_TYPES",
	        joinColumns={@JoinColumn(name="CITY_ID", referencedColumnName="ID")},
	        inverseJoinColumns={@JoinColumn(name="UNIT_TYPE_IDENT", referencedColumnName="IDENT")})
	private Set<UnitType> enabledUnitTypes;
	@OneToMany(fetch=FetchType.EAGER)
	private Set<TradeRoute> tradeRoutes;
	@OneToOne
	private Tile cityCentre;
	@ManyToOne
	private Player owner;
	@OneToMany(fetch=FetchType.EAGER)
	private Set<Tile> managedTiles;
	@Column(nullable=false)
	private Integer size;
	private Boolean weLoveDay;
	private Boolean disorder;
	private Integer foodProduction;
	private Integer foodConsumption;
	private Integer foodSurplus;
	private Integer foodStock;
	private Integer resourcesProduction;
	private Integer resourcesConsumption;
	private Integer resourcesSurplus;
	private Integer tradeProduction;
	private Integer corruption; // lost of trade
	private Integer luxuriesAmount;
	private Integer luxuriesSpent;
	private Integer taxesAmount;
	private Integer researchAmount;
	private Integer peopleHappy;
	private Integer peopleUnhappy;
	private Integer peopleContent;
	private Integer peopleEntertainers;
	private Integer peopleTaxmen;
	private Integer peopleScientists;
	private Integer pollutionChance;
	private Integer improvementsUpkeep; // lost of taxesAmount
	private Integer unitsSupport;
	private Integer unitsFoodSupport;
	
	private static final long serialVersionUID = 1L;

	public City() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	
	public Tile getCityCentre() {
		return cityCentre;
	}
	public void setCityCentre(Tile cityCentre) {
		this.cityCentre = cityCentre;
	}
	public Set<CityImprovement> getImprovements() {
		return improvements;
	}
	public void setImprovements(Set<CityImprovement> improvements) {
		this.improvements = improvements;
	}
	public Set<CityImprovement> getEnabledImprovements() {
		return enabledImprovements;
	}
	public void setEnabledImprovements(Set<CityImprovement> enabledImprovements) {
		this.enabledImprovements = enabledImprovements;
	}
	public Set<Unit> getHomeUnits() {
		return homeUnits;
	}
	public void setHomeUnits(Set<Unit> homeUnits) {
		this.homeUnits = homeUnits;
	}
	public Set<UnitType> getEnabledUnitTypes() {
		return enabledUnitTypes;
	}
	public void setEnabledUnitTypes(Set<UnitType> enabledUnitTypes) {
		this.enabledUnitTypes = enabledUnitTypes;
	}
	public Set<TradeRoute> getTradeRoutes() {
		return tradeRoutes;
	}
	public void setTradeRoutes(Set<TradeRoute> tradeRoutes) {
		this.tradeRoutes = tradeRoutes;
	}
	public Player getOwner() {
		return owner;
	}
	public void setOwner(Player owner) {
		this.owner = owner;
	}	
	/**
	 * @return the managedTiles
	 */
	public Set<Tile> getManagedTiles() {
		return managedTiles;
	}
	/**
	 * @param managedTiles the managedTiles to set
	 */
	public void setManagedTiles(Set<Tile> managedTiles) {
		this.managedTiles = managedTiles;
	}
	public CityImprovement getCurrentImprovement() {
		return currentImprovement;
	}
	public void setCurrentImprovement(CityImprovement currentImprovement) {
		this.currentImprovement = currentImprovement;
	}
	public UnitType getCurrentUnit() {
		return currentUnit;
	}
	public void setCurrentUnit(UnitType currentUnit) {
		this.currentUnit = currentUnit;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public Boolean getWeLoveDay() {
		return weLoveDay;
	}
	public void setWeLoveDay(Boolean weLoveDay) {
		this.weLoveDay = weLoveDay;
	}
	public Boolean getDisorder() {
		return disorder;
	}
	public void setDisorder(Boolean disorder) {
		this.disorder = disorder;
	}
	public Integer getFoodProduction() {
		return foodProduction;
	}
	public void setFoodProduction(Integer foodProduction) {
		this.foodProduction = foodProduction;
	}
	public Integer getFoodConsumption() {
		return foodConsumption;
	}
	public void setFoodConsumption(Integer foodConsumption) {
		this.foodConsumption = foodConsumption;
	}
	public Integer getFoodSurplus() {
		return foodSurplus;
	}
	public void setFoodSurplus(Integer foodSurplus) {
		this.foodSurplus = foodSurplus;
	}
	public Integer getFoodStock() {
		return foodStock;
	}
	public void setFoodStock(Integer foodStock) {
		this.foodStock = foodStock;
	}
	public Integer getResourcesProduction() {
		return resourcesProduction;
	}
	public void setResourcesProduction(Integer resourcesProduction) {
		this.resourcesProduction = resourcesProduction;
	}
	public Integer getResourcesConsumption() {
		return resourcesConsumption;
	}
	public void setResourcesConsumption(Integer resourcesConsumption) {
		this.resourcesConsumption = resourcesConsumption;
	}
	public Integer getResourcesSurplus() {
		return resourcesSurplus;
	}
	public void setResourcesSurplus(Integer resourcesSurplus) {
		this.resourcesSurplus = resourcesSurplus;
	}
	public Integer getTradeProduction() {
		return tradeProduction;
	}
	public void setTradeProduction(Integer tradeProduction) {
		this.tradeProduction = tradeProduction;
	}
	public Integer getCorruption() {
		return corruption;
	}
	public void setCorruption(Integer corruption) {
		this.corruption = corruption;
	}
	public Integer getLuxuriesAmount() {
		return luxuriesAmount;
	}
	public void setLuxuriesAmount(Integer luxuriesAmount) {
		this.luxuriesAmount = luxuriesAmount;
	}
	
	public Integer getLuxuriesSpent() {
		return luxuriesSpent;
	}
	public void setLuxuriesSpent(Integer luxuriesSpent) {
		this.luxuriesSpent = luxuriesSpent;
	}
	public Integer getTaxesAmount() {
		return taxesAmount;
	}
	public void setTaxesAmount(Integer taxesAmount) {
		this.taxesAmount = taxesAmount;
	}
	public Integer getResearchAmount() {
		return researchAmount;
	}
	public void setResearchAmount(Integer researchAmount) {
		this.researchAmount = researchAmount;
	}
	public Integer getPeopleHappy() {
		return peopleHappy;
	}
	public void setPeopleHappy(Integer peopleHappy) {
		this.peopleHappy = peopleHappy;
	}
	public Integer getPeopleUnhappy() {
		return peopleUnhappy;
	}
	public void setPeopleUnhappy(Integer peopleUnhappy) {
		this.peopleUnhappy = peopleUnhappy;
	}
	public Integer getPeopleContent() {
		return peopleContent;
	}
	public void setPeopleContent(Integer peopleContent) {
		this.peopleContent = peopleContent;
	}
	public Integer getPeopleEntertainers() {
		return peopleEntertainers;
	}
	public void setPeopleEntertainers(Integer peopleEntertainers) {
		this.peopleEntertainers = peopleEntertainers;
	}
	public Integer getPeopleTaxmen() {
		return peopleTaxmen;
	}
	public void setPeopleTaxmen(Integer peopleTaxmen) {
		this.peopleTaxmen = peopleTaxmen;
	}
	public Integer getPeopleScientists() {
		return peopleScientists;
	}
	public void setPeopleScientists(Integer peopleScientists) {
		this.peopleScientists = peopleScientists;
	}
	public Integer getPollutionChance() {
		return pollutionChance;
	}
	public void setPollutionChance(Integer pollutionChance) {
		this.pollutionChance = pollutionChance;
	}
	public Integer getImprovementsUpkeep() {
		return improvementsUpkeep;
	}
	public void setImprovementsUpkeep(Integer improvementsUpkeep) {
		this.improvementsUpkeep = improvementsUpkeep;
	}
	public Integer getUnitsSupport() {
		return unitsSupport;
	}
	public void setUnitsSupport(Integer unitsSupport) {
		this.unitsSupport = unitsSupport;
	}
	/**
	 * @return the unitsFoodSupport
	 */
	public Integer getUnitsFoodSupport() {
		return unitsFoodSupport;
	}
	/**
	 * @param unitsFoodSupport the unitsFoodSupport to set
	 */
	public void setUnitsFoodSupport(Integer unitsFoodSupport) {
		this.unitsFoodSupport = unitsFoodSupport;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((cityCentre == null) ? 0 : cityCentre.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
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
		City other = (City) obj;
		if (cityCentre == null) {
			if (other.cityCentre != null)
				return false;
		} else if (!cityCentre.equals(other.cityCentre))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		return true;
	}

   
}
