package cz.muni.fi.civ.newohybat.persistence.facade.dto;

import java.io.Serializable;

public class TradeRouteDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2745186027075510835L;
	private Long id;
	private CityDTO destination;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public CityDTO getDestination() {
		return destination;
	}
	public void setDestination(CityDTO destination) {
		this.destination = destination;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		TradeRouteDTO other = (TradeRouteDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TradeRouteDTO [id=" + id + ", destination=" + destination + "]";
	}
	
	
}
