package business;

import data.dao.KartDAO;
import data.common.EstadoKart;

public class KartMgr {

	public static boolean addKart(int id, boolean child, EstadoKart state) {
		KartDTO kart = new KartDTO(id, child, state);
		KartDAO.crearKart(kart);
		return true;
	}
	
}
