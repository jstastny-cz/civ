package cz.muni.fi.civ.newohybat.persistence.facade.dto;

import java.io.Serializable;

import org.kie.api.definition.type.PropertyReactive;
/**
 * Class which represents an improvement which can be built in a city.
 * @author newohybat
 *
 */
@PropertyReactive
public class CityImprovementDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7925970213597161705L;
	private String ident;
	private String name;
	private String description;
	private Boolean wonder;
	private String obsoletedByAdvance;
	private String obsoletedByImprovement;
	private Integer constructionCost;
	private Integer upkeepCost; 
	
	public CityImprovementDTO(){
		wonder = false;
		constructionCost=0;
		upkeepCost=0;
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
	public Boolean getWonder() {
		return wonder;
	}
	public void setWonder(Boolean wonder) {
		this.wonder = wonder;
	}
	
	public String getObsoletedByAdvance() {
		return obsoletedByAdvance;
	}
	public void setObsoletedByAdvance(String obsoletedByAdvance) {
		this.obsoletedByAdvance = obsoletedByAdvance;
	}
	public String getObsoletedByImprovement() {
		return obsoletedByImprovement;
	}
	public void setObsoletedByImprovement(String obsoletedByImprovement) {
		this.obsoletedByImprovement = obsoletedByImprovement;
	}
	
	public Integer getConstructionCost() {
		return constructionCost;
	}
	public void setConstructionCost(Integer constructionCost) {
		this.constructionCost = constructionCost;
	}
	public Integer getUpkeepCost() {
		return upkeepCost;
	}
	public void setUpkeepCost(Integer upkeepCost) {
		this.upkeepCost = upkeepCost;
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
		CityImprovementDTO other = (CityImprovementDTO) obj;
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
		return "CityImprovementDTO [ident=" + ident + ", name=" + name
				+ ", description=" + description + ", wonder=" + wonder
				+ ", obsoletedByAdvance=" + obsoletedByAdvance
				+ ", obsoletedByImprovement=" + obsoletedByImprovement
				+ ", constructionCost=" + constructionCost + ", upkeepCost="
				+ upkeepCost + "]";
	}
	

	
}
