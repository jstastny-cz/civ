package cz.muni.fi.civ.newohybat.persistence.dao.impl;

import java.util.List;

import javax.persistence.Query;

import cz.muni.fi.civ.newohybat.persistence.dao.iface.TileImprovementDAO;
import cz.muni.fi.civ.newohybat.persistence.entities.TileImprovement;

public class TileImprovementDAOImpl extends BaseDAOImpl<TileImprovement> implements TileImprovementDAO{
	public TileImprovementDAOImpl(){
		super();
	}
	@Override
	protected boolean isValid(TileImprovement object) {
		return object.getIdent()!=null && !object.getIdent().isEmpty();
	}
	
	public TileImprovement getByIdent(String ident) {
		Query q = getEntityManager().createQuery("SELECT t FROM TileImprovement t WHERE t.ident=:ident");
		q.setParameter("ident", ident);
		List<TileImprovement> actionList = (List<TileImprovement>)q.getResultList();
		if(!actionList.isEmpty()){
			return actionList.get(0);
		}
		return null;
	}



}
