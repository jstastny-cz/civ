package cz.muni.fi.civ.newohybat.persistence.dao.impl;


import java.util.List;

import javax.persistence.Query;

import cz.muni.fi.civ.newohybat.persistence.dao.iface.TerrainDAO;
import cz.muni.fi.civ.newohybat.persistence.entities.Terrain;

public class TerrainDAOImpl extends BaseDAOImpl<Terrain> implements TerrainDAO {

	@Override
	protected boolean isValid(Terrain object) {
		return object.getIdent()!=null&&!object.getIdent().isEmpty();
	}

	public Terrain getByIdent(String ident) {
		Query q = getEntityManager().createQuery("SELECT t FROM Terrain t WHERE t.ident=:ident");
		q.setParameter("ident", ident);
		List<Terrain> actionList = q.getResultList();
		if(!actionList.isEmpty()){
			return actionList.get(0);
		}
		return null;
	}



}
