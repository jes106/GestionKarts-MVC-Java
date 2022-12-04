package data.common;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SystemManager {
		
	public static Timestamp StringToDateSQL(String date_) {
		
		DateFormat formato = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		java.util.Date fecha = null;
		try {
			fecha = formato.parse(date_);
		} catch (ParseException e) { e.printStackTrace(); }
		
		Timestamp date = new Timestamp(fecha.getTime());

		return date;
	}
	
	public static Timestamp DateToDateSQL(java.util.Date date_) {
		Timestamp date = new Timestamp(date_.getTime());
		return date;
	}
	
	public static Timestamp SumaRestaFecha(Timestamp date, int min, String op){
		
		DateFormat formateador = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		
		if(op.equals("s")) { cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) + min); }
		else if(op.equals("r")) { cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) - min); }
		
		return SystemManager.StringToDateSQL(formateador.format(new Timestamp(cal.getTime().getTime())));
	}
}
