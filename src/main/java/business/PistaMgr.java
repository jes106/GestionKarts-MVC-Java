package business;

import data.dao.PistaDAO;
import data.common.Dificultad;
/***
 * A handler for the Tracks
 * @author Jesús Escribano Serena
 *
 */
public class PistaMgr {
	
	/***
	 * Function that helps to create a new track
	 * @param name the name of the track
	 * @param state the initial state for the track
	 * @param difficulty if the track is for child, adults or familiar
	 * @param kartMax the max number of karts in the track
	 */

	public static boolean addTrack(String name, boolean state, Dificultad difficulty, int kartMax) {
		PistaDTO track = new PistaDTO(name, state, difficulty, kartMax);
		PistaDAO.crearPista(track);
		return true;
	}
	
}
