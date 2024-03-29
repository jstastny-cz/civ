package cz.muni.fi.civ.newohybat.drools.events;

import java.io.Serializable;
/**
 * Event Class to signal events about Unit which is moving.
 * @author newohybat
 *
 */
public class MoveEvent implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5331331540799291178L;
	private final Long unitId;

	public MoveEvent(Long unitId){
		this.unitId=unitId;
	}
	
	public Long getUnitId() {
		return unitId;
	}
	
	private transient String toString;
	
	@Override
	public String toString() {
		if (toString == null) {
			toString = super.toString() + this.getClass().toString() + ":" + unitId;
		}
	return toString;
	}
}
