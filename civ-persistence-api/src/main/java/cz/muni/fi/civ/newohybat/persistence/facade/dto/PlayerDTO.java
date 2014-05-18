package cz.muni.fi.civ.newohybat.persistence.facade.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.kie.api.definition.type.PropertyReactive;
/**
 * Class represents a player.
 * @author newohybat
 *
 */
@PropertyReactive
public class PlayerDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6438577026379092559L;
	private Long id;
	private String name;
	private String government;
	private Set<String> enabledGovernments;
	private String currentAdvance;
	private Set<String> advances;
	private Set<String> enabledAdvances;
	private Integer treasury;
	private Integer research;
	private Integer researchSpent;
	private Integer turnsAvailable;
	private Integer luxuriesRatio;
	private Integer taxesRatio;
	private Integer researchRatio;
	
	public PlayerDTO(){
		enabledGovernments = new HashSet<String>();
		advances = new HashSet<String>();
		enabledAdvances = new HashSet<String>();
		treasury = 0;
		research = 0;
		researchSpent = 0;
		turnsAvailable = 0;
		luxuriesRatio = 0;
		taxesRatio = 0;
		researchRatio = 0;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		if(this.id!=null) throw new IllegalStateException("Attempt to change unchangeable property.");
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGovernment() {
		return government;
	}
	public void setGovernment(String government) {
		this.government = government;
	}
	public Set<String> getEnabledGovernments() {
		return enabledGovernments;
	}
	public void setEnabledGovernments(Set<String> enabledGovernments) {
		this.enabledGovernments = enabledGovernments;
	}
	public void setAdvances(Set<String> advances) {
		this.advances = advances;
	}
	public void setEnabledAdvances(Set<String> enabledAdvances) {
		this.enabledAdvances = enabledAdvances;
	}
	public String getCurrentAdvance() {
		return currentAdvance;
	}
	public void setCurrentAdvance(String currentAdvance) {
		this.currentAdvance = currentAdvance;
	}
	public Set<String> getAdvances() {
		return advances;
	}
	public Set<String> getEnabledAdvances() {
		return enabledAdvances;
	}
	public Integer getTreasury() {
		return treasury;
	}
	public void setTreasury(Integer treasury) {
		this.treasury = treasury;
	}
	public Integer getResearch() {
		return research;
	}
	public void setResearch(Integer research) {
		this.research = research;
	}
	public Integer getResearchSpent() {
		return researchSpent;
	}
	public void setResearchSpent(Integer researchSpent) {
		this.researchSpent = researchSpent;
	}
	public Integer getTurnsAvailable() {
		return turnsAvailable;
	}
	public void setTurnsAvailable(Integer turnsAvailable) {
		this.turnsAvailable = turnsAvailable;
	}
	public Integer getLuxuriesRatio() {
		return luxuriesRatio;
	}
	public void setLuxuriesRatio(Integer luxuriesRatio) {
		this.luxuriesRatio = luxuriesRatio;
	}
	public Integer getTaxesRatio() {
		return taxesRatio;
	}
	public void setTaxesRatio(Integer taxesRatio) {
		this.taxesRatio = taxesRatio;
	}
	public Integer getResearchRatio() {
		return researchRatio;
	}
	public void setResearchRatio(Integer researchRatio) {
		this.researchRatio = researchRatio;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		PlayerDTO other = (PlayerDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PlayerDTO [id=" + id + ", name=" + name + ", government=" + government
				+ ", enabledGovernments=" + enabledGovernments
				+ ", currentAdvance=" + currentAdvance + ", advances="
				+ advances + ", enabledAdvances=" + enabledAdvances
				+ ", treasury=" + treasury + ", research=" + research
				+ ", researchSpent=" + researchSpent + ", turnsAvailable="
				+ turnsAvailable + ", luxuriesRatio=" + luxuriesRatio
				+ ", taxesRatio=" + taxesRatio + ", researchRatio="
				+ researchRatio + "]";
	}
	
	
	
	

	
}
