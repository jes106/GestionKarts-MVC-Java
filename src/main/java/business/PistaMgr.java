package business;

import data.dao.PistaDAO;
import data.common.Dificultad;

public class PistaMgr {

	public static void addTrack(String name, boolean state, Dificultad difficulty, int kartMax) {
		PistaDTO track = new PistaDTO(name, state, difficulty, kartMax);
		PistaDAO.crearPista(track);
	}
	
}
