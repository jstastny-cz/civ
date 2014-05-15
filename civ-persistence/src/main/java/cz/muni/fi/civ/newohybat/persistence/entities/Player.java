package cz.muni.fi.civ.newohybat.persistence.entities;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Player
 *
 */
@Entity

public class Player implements Serializable {

	   
	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable=false)
	private String name;
	
	@ManyToOne
	@JoinColumn(nullable=true)
	private Government government;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="PLAYER_ENABLED_GOVERNMENTS",
	joinColumns={@JoinColumn(name="PLAYER_ID", referencedColumnName="ID")},
    inverseJoinColumns={@JoinColumn(name="GOVERNMENT_IDENT", referencedColumnName="IDENT")})
	private Set<Government> enabledGovernments;
	
	@ManyToOne
	@JoinColumn(nullable=true)
	private Advance currentAdvance;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="PLAYER_ADVANCE",
	joinColumns={@JoinColumn(name="PLAYER_ID", referencedColumnName="ID")},
    inverseJoinColumns={@JoinColumn(name="ADVANCE_IDENT", referencedColumnName="IDENT")})
	private Set<Advance> advances;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="PLAYER_ENABLED_ADVANCE",
	joinColumns={@JoinColumn(name="PLAYER_ID", referencedColumnName="ID")},
    inverseJoinColumns={@JoinColumn(name="ADVANCE_IDENT", referencedColumnName="IDENT")})
	private Set<Advance> enabledAdvances;
	
	private Integer treasury;
	private Integer research;
	private Integer researchSpent;
	private Integer turnsAvailable;
	private Integer luxuriesRatio;
	private Integer taxesRatio;
	private Integer researchRatio;
	
	private static final long serialVersionUID = 1L;

	public Player() {
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
	
	public void setAdvances(Set<Advance> advances) {
		this.advances = advances;
	}
	public Government getGovernment() {
		return government;
	}
	public void setGovernment(Government government) {
		this.government = government;
	}
	
	public Advance getCurrentAdvance() {
		return currentAdvance;
	}
	public void setCurrentAdvance(Advance currentAdvance) {
		this.currentAdvance = currentAdvance;
	}
	public Set<Advance> getAdvances() {
		return advances;
	}
	public Set<Government> getEnabledGovernments() {
		return enabledGovernments;
	}
	public void setEnabledGovernments(Set<Government> enabledGovernments) {
		this.enabledGovernments = enabledGovernments;
	}
	public Set<Advance> getEnabledAdvances() {
		return enabledAdvances;
	}
	public void setEnabledAdvances(Set<Advance> enabledAdvances) {
		this.enabledAdvances = enabledAdvances;
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
		Player other = (Player) obj;
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
	
   
}
