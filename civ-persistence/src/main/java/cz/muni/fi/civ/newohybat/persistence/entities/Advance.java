package cz.muni.fi.civ.newohybat.persistence.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Advance
 *
 */
@Entity

public class Advance implements Serializable {

	@Id
	private String ident;
	@Column(nullable=false)
	private String name;
	private String description;
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "ADVANCE_ENABLED", 
			joinColumns = {
			 @JoinColumn(name = "enablement", referencedColumnName = "ident", nullable = true)},
			inverseJoinColumns = {
			 @JoinColumn(name = "requirement", referencedColumnName = "ident", nullable = true)}
	)
	private Set<Advance> enabledAdvances;
	@OneToMany(fetch=FetchType.EAGER)
	private Set<CityImprovement> enabledCityImprovements;
	@OneToMany(fetch=FetchType.EAGER)
	private Set<UnitType> enabledUnitTypes;
	@OneToMany(fetch=FetchType.EAGER)
	private Set<Government> enabledGovernments;
	private Integer cost;
	
	private static final long serialVersionUID = 1L;

	public Advance() {
		super();
	}   
	public String getIdent() {
		return this.ident;
	}

	public void setIdent(String ident) {
		this.ident = ident;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description = description;
	}   
	
	public Set<Advance> getEnabledAdvances() {
		return enabledAdvances;
	}
	public void setEnabledAdvances(Set<Advance> enabledAdvances) {
		this.enabledAdvances = enabledAdvances;
	}
	public Set<CityImprovement> getEnabledCityImprovements() {
		return enabledCityImprovements;
	}
	public void setEnabledCityImprovements(
			Set<CityImprovement> enabledCityImprovements) {
		this.enabledCityImprovements = enabledCityImprovements;
	}
	
	
	public Set<UnitType> getEnabledUnitTypes() {
		return enabledUnitTypes;
	}
	public void setEnabledUnitTypes(Set<UnitType> enabledUnitTypes) {
		this.enabledUnitTypes = enabledUnitTypes;
	}
	
	public Set<Government> getEnabledGovernments() {
		return enabledGovernments;
	}
	public void setEnabledGovernments(Set<Government> enabledGovernments) {
		this.enabledGovernments = enabledGovernments;
	}
	public Integer getCost() {
		return cost;
	}
	public void setCost(Integer cost) {
		this.cost = cost;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ident == null) ? 0 : ident.hashCode());
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
		Advance other = (Advance) obj;
		if (ident == null) {
			if (other.ident != null)
				return false;
		} else if (!ident.equals(other.ident))
			return false;

		return true;
	}
}
