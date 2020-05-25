/**
 * 
 */
package fr.lusseau.claude.bibliotheques.utils;

import java.lang.ref.SoftReference;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Classe en charge de
 * 
 * @Version Bibliotheques -v1,0
 * @date 24 mai 2020 - 19:46:16
 * @author claudelusseau
 *
 */
public class DateUtil {

	private static final ThreadLocal<SoftReference<DateFormat>> format = new ThreadLocal<SoftReference<DateFormat>>();

	private static DateFormat getDateFormat() {
		SoftReference<DateFormat> softRef = format.get();
		if (softRef != null) {
			final DateFormat result = softRef.get();
			if (result != null) {
				return result;
			}
		}
		final DateFormat result = new SimpleDateFormat("dd-MM-yyyy");
		softRef = new SoftReference<DateFormat>(result);
		format.set(softRef);
		return result;
	}

	public static final Date parse(final String date) throws ParseException {
		return getDateFormat().parse(date);
	}

	public static final String format(final Date date) throws ParseException {
		return getDateFormat().format(date);
	}
}
