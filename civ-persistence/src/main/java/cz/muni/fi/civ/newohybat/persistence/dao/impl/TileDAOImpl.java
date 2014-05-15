package cz.muni.fi.civ.newohybat.persistence.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import cz.muni.fi.civ.newohybat.persistence.dao.iface.TileDAO;
import cz.muni.fi.civ.newohybat.persistence.entities.Tile;

public class TileDAOImpl extends BaseDAOImpl<Tile> implements TileDAO {
	@Override
    protected boolean isValid(Tile object) {
		return object.getImprovements()!=null
				&& object.getPosX()!=null
				&& object.getPosY()!=null
				&& object.getTerrain()!=null
//				&& object.getUnits()!=null
				;
    }

	public Tile getByPosition(Long x, Long y) {
			Tile tile= null;
	        Query q = getEntityManager().createQuery("SELECT o FROM Tile o WHERE o.posX=? AND o.posY=?");
	        q.setParameter(1, x);
	        q.setParameter(2, y);
	        if(q.getResultList().size()==1){
	        	tile = (Tile)(q.getResultList().get(0));
	        }
	        return tile;
	}

	public Map<Long,List<Tile>> getTilesInRectangle(Long topLeftX, Long topLeftY,
			Long bottomRightX, Long bottomRightY) {
		Query q = getEntityManager().createQuery("SELECT o FROM Tile o WHERE o.posX<=? AND o.posX>=? AND o.posY<=? AND o.posY>=? ORDER BY o.posX,o.posY");
        q.setParameter(1, bottomRightX);
        q.setParameter(2, topLeftX);
        q.setParameter(3, bottomRightY);
        q.setParameter(4, topLeftY);
		// TODO Auto-generated method stub
        List<Tile> tiles = (List<Tile>)q.getResultList();
        Map<Long,List<Tile>> tilesGroupedByX = new HashMap<Long, List<Tile>>();
        for(Long i=topLeftX;i<=bottomRightX;i++){
        	tilesGroupedByX.put(i, new ArrayList<Tile>());
        }
        for(Tile t: tiles){
        	tilesGroupedByX.get(t.getPosX()).add(t);
        }
		return tilesGroupedByX;
	}


}
