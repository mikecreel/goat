package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Mike Creel
 * Created 3/18/2016 
 */
public class FormatDate {

	public String FormatMyDate (String MyDate)  {
		String DateToStr ="";
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		dateFormat.setLenient(false);
		Date date;
		try {
			date = dateFormat.parse(MyDate);
			DateToStr = dateFormat.format(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return DateToStr;
	}

}


