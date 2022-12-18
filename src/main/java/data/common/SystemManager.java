package data.common;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/***
 * Function that control the use of the dates
 * @author Antonio Díaz Pérez
 *
 */
public class SystemManager {
	
	/***
	 * Convert a date in string format to SQL format
	 * @param date_ the date in string format
	 * @return the date in SQL format
	 */
	public static Timestamp StringToDateSQL(String date_) {
		
		DateFormat formato = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		java.util.Date fecha = null;
		try {
			fecha = formato.parse(date_);
		} catch (ParseException e) { e.printStackTrace(); }
		
		Timestamp date = new Timestamp(fecha.getTime());

		return date;
	}
	
	/***
	 * Convert a date in string format to SQL format
	 * @param date_ the date in string format
	 * @return the date in SQL format
	 */
	
	public static Timestamp StringToDateSQL2(String date_) {
		
		DateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date fecha = null;
		try {
			fecha = formato.parse(date_);
		} catch (ParseException e) { e.printStackTrace(); }
		
		Timestamp date = new Timestamp(fecha.getTime());

		return date;
	}
	
	/***
	 * Function to convert a Java Date into SQL Date
	 * @param date_ the data in Java format
	 * @return the date in SQL format
	 */
	public static Timestamp DateToDateSQL(java.util.Date date_) {
		Timestamp date = new Timestamp(date_.getTime());
		return date;
	}
	
	/***
	 * Function to make additions with dates
	 * @param date date to make the operations
	 * @param min the mins to add or subtract
	 * @param op the operation to do (addition or subtract)
	 * @return the new date with the operation done
	 */
	public static Timestamp SumaRestaFecha(Timestamp date, int min, String op){
		
		DateFormat formateador = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		
		if(op.equals("s")) { cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) + min); }
		else if(op.equals("r")) { cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) - min); }
		
		return SystemManager.StringToDateSQL(formateador.format(new Timestamp(cal.getTime().getTime())));
	}
}
