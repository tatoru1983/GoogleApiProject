package utility;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DataUtility {
	
	public static BigDecimal getCurrentYear() {
		Date date = new Date();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		return BigDecimal.valueOf(year);
	}

}
