package cz.muni.fi.civ.newohybat.persistence.facade.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.kie.api.definition.type.PropertyReactive;

@PropertyReactive
public class AdvanceDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 92045097809768765L;
	private String ident;
	private String name;
	private String description;
	private Set<String> enabledAdvances;
	private Set<String> enabledCityImprovements;
	private Set<String> enabledUnitTypes;
	private Set<String> enabledGovernments;
	private Integer cost;
	
	public AdvanceDTO(){
		enabledAdvances = new HashSet<String>();
		enabledCityImprovements = new HashSet<String>();
		enabledGovernments = new HashSet<String>();
		enabledUnitTypes = new HashSet<String>();
	}
	
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
	public Set<String> getEnabledAdvances() {
		return enabledAdvances;
	}
	public void setEnabledAdvances(Set<String> enabledAdvances) {
		this.enabledAdvances = enabledAdvances;
	}
	public Set<String> getEnabledCityImprovements() {
		return enabledCityImprovements;
	}
	public void setEnabledCityImprovements(Set<String> enabledCityImprovements) {
		this.enabledCityImprovements = enabledCityImprovements;
	}
	public Set<String> getEnabledUnitTypes() {
		return enabledUnitTypes;
	}
	public void setEnabledUnitTypes(Set<String> enabledUnitTypes) {
		this.enabledUnitTypes = enabledUnitTypes;
	}
	public Set<String> getEnabledGovernments() {
		return enabledGovernments;
	}
	public void setEnabledGovernments(Set<String> enabledGovernments) {
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
		AdvanceDTO other = (AdvanceDTO) obj;
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
		return "AdvanceDTO [ident=" + ident + ", name=" + name
				+ ", description=" + description + ", enabledAdvances="
				+ enabledAdvances
				+ ", enabledCityImprovements=" + enabledCityImprovements
				+ ", enabledUnitTypes=" + enabledUnitTypes
				+ ", enabledGovernments=" + enabledGovernments + ", cost="
				+ cost + "]";
	}
	
	
	
	
	
}
