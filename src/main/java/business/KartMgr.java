package business;

import data.dao.KartDAO;
import data.common.EstadoKart;
/***
 * The manager for the karts
 * @author Antonio Díaz Pérez
 *
 */
public class KartMgr {

	/***
	 * Function to add a new car
	 * @param id The id for the kart to create
	 * @param child A boolean that represent if the kart is for children or not
	 * @param state The state of registration of a kart (Disponible, En Mantenimiento, Reservado)
	 * @return true if the kart was created
	 */
	public static boolean addKart(int id, boolean child, EstadoKart state) {
		KartDTO kart = new KartDTO(id, child, state);
		KartDAO.crearKart(kart);
		return true;
	}
	
}
