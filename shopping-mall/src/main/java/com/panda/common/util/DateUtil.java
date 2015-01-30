package com.panda.common.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Date Utility Class
 * This is used to convert Strings to Dates and Timestamps
 *
 * <p>
 * <a href="DateUtil.java.html"><i>View Source</i></a>
 * </p>
 * 

 */
public class DateUtil {
	//~ Static fields/initializers =============================================

	private static Log log = LogFactory.getLog(DateUtil.class);
	private static String datePattern = "yyyy年MM月dd日";
	private static String timePattern = "HH:mm";

	//~ Methods ================================================================

	/**
	 * Return default datePattern (yyyy年MM月dd日)
	 * @return a string representing the date pattern on the UI
	 */
	public static String getDatePattern() {
		return datePattern;
	}

	/**
	 * This method attempts to convert an Oracle-formatted date
	 * in the form dd-MMM-yyyy to yyyy年MM月dd日.
	 *
	 * @param aDate date from database as a string
	 * @return formatted string for the ui
	 */
	public static final String getDate(Date aDate) {
		SimpleDateFormat df = null;
		String returnValue = "";

		if (aDate != null) {
			df = new SimpleDateFormat(datePattern);
			returnValue = df.format(aDate);
		}
		return (returnValue);
	}

	/**
	 * This method generates a string representation of a date/time
	 * in the format you specify on input
	 *
	 * @param aMask the date pattern the string is in
	 * @param strDate a string representation of a date
	 * @return a converted Date object
	 * @see java.text.SimpleDateFormat
	 * @throws ParseException
	 */
	public static final Date convertStringToDate(String aMask, String strDate) throws ParseException {
		SimpleDateFormat df = null;
		Date date = null;
		df = new SimpleDateFormat(aMask);

/*		if (log.isDebugEnabled()) {
			log.debug("converting '" + strDate + "' to date with mask '" + aMask + "'");
		}*/

		try {
			date = df.parse(strDate);
		} catch (ParseException pe) {
			//log.error("ParseException: " + pe);
			throw new ParseException(pe.getMessage(), pe.getErrorOffset());
		}

		return (date);
	}

	/**
	 * This method returns the current date time in the format:
	 * MM/dd/yyyy HH:MM a
	 *
	 * @param theTime the current time
	 * @return the current date/time
	 */
	public static String getTimeNow(Date theTime) {
		return getDateTime(timePattern, theTime);
	}

	/**
	 * This method returns the current date in the format: MM/dd/yyyy
	 * 
	 * @return the current date
	 * @throws ParseException
	 */
	public static Calendar getToday() throws ParseException {
		Date today = new Date();
		SimpleDateFormat df = new SimpleDateFormat(datePattern);

		// This seems like quite a hack (date -> string -> date),
		// but it works ;-)
		String todayAsString = df.format(today);
		Calendar cal = new GregorianCalendar();
		cal.setTime(convertStringToDate(todayAsString));
		
		return cal;
	}

	/**
	 * This method generates a string representation of a date's date/time
	 * in the format you specify on input
	 *
	 * @param aMask the date pattern the string is in
	 * @param aDate a date object
	 * @return a formatted string representation of the date
	 * 
	 * @see java.text.SimpleDateFormat
	 */
	public static final String getDateTime(String aMask, Date aDate) {
		SimpleDateFormat df = null;
		String returnValue = "";

		if (aDate == null) {
			log.error("aDate is null!");
		} else {
			df = new SimpleDateFormat(aMask);
			returnValue = df.format(aDate);
		}

		return (returnValue);
	}

	/**
	 * This method generates a string representation of a date based
	 * on the System Property 'dateFormat'
	 * in the format you specify on input
	 * 
	 * @param aDate A date to convert
	 * @return a string representation of the date
	 */
	public static final String convertDateToString(Date aDate) {
		return getDateTime(datePattern, aDate);
	}

	/**
	 * 
	 * @param aMask
	 * @param aDate
	 * @return
	 */
	public static final String convertDateToString(String aMask, Date aDate) {
		return getDateTime(aMask, aDate);
	}

	/**
	 * This method converts a String to a date using the datePattern
	 * 
	 * @param strDate the date to convert (in format MM/dd/yyyy)
	 * @return a date object
	 * 
	 * @throws ParseException
	 */
	public static Date convertStringToDate(String strDate) throws ParseException {
		Date aDate = null;
		try {
			if (log.isDebugEnabled()) {
				log.debug("converting date with pattern: " + datePattern);
			}
			aDate = convertStringToDate(datePattern, strDate);
		} catch (ParseException pe) {
			log.error("Could not convert '" + strDate + "' to a date, throwing exception");
			pe.printStackTrace();
			throw new ParseException(pe.getMessage(), pe.getErrorOffset());
		}

		return aDate;
	}

	public static Date StringToDate(String param) {
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = sdf.parse(param);
		} catch (ParseException ex) {
		}
		return date;
	}

	public static Timestamp convertStringToTimestamp(String strDate) {
		java.util.Date date = null;

		try {
			date = convertStringToDate(datePattern, strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date == null ? null : new Timestamp(date.getTime());
	}

	public static Timestamp convertStringToTimestamp(String aMask, String strDate) {
		java.util.Date date = null;
		try {
			date = convertStringToDate(aMask, strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date == null ? null : new Timestamp(date.getTime());
	}

	public static final String convertTimestampToString(String aMask, Timestamp aDate) {
		return getDateTime(aMask, aDate);

	}

	public static final String convertTimestampToString(Timestamp aDate) {
		return getDateTime(datePattern, aDate);

	}

	public static Timestamp getNowDateToTimestamp(String aMask) {
		return convertStringToTimestamp(aMask, getDate(aMask, new Date()));
	}

	public static final String getDate(String aMask, Date aDate) {
		SimpleDateFormat df = null;
		String returnValue = "";

		if (aDate != null) {
			df = new SimpleDateFormat(aMask);
			returnValue = df.format(aDate);
		}
		return (returnValue);
	}

	public static String getLastMon() {
		Date dt = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMM");
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(dt);
		gc.add(2, -1);
		gc.set(gc.get(gc.YEAR), gc.get(gc.MONTH), gc.get(gc.DATE));
		return df.format(gc.getTime());
	}
	
	//获得日期的0点
	public static final Date getDayBeginTime(Date aDate){
		try{
			String daystr = getDateTime("yyyyMMdd", aDate);
			daystr=daystr+"000000";
			return convertStringToDate("yyyyMMddHHmmss",daystr);
		}
		catch(Exception e){
			return null;
		}
	}
	
	//获得日期的23点59分59秒
	public static final Date getDayEndTime(Date aDate){
		try{
			String daystr = getDateTime("yyyyMMdd", aDate);
			daystr=daystr+"235959";
			return convertStringToDate("yyyyMMddHHmmss",daystr);
		}
		catch(Exception e){
			return null;
		}
	}
	//获得完整的（）精确到毫秒的日期yyyyMMddHHmmssSSS
	public static final String getFullTimeStr()
	{
	    //定义Format的格式
	    String p_pattern = "yyyyMMddHHmmssSSS";
	    SimpleDateFormat p_sdf = new SimpleDateFormat(p_pattern);
	    
	    //定义要转换的Date对象
	    Calendar p_cal = Calendar.getInstance();
	    Date p_date = p_cal.getTime();
	
	    return p_sdf.format(p_date);
	}
	
	public static void main(String[] args) {
		//System.out.println(getDateTime("yyyyMMddHHmmss", new Date()));
		//System.out.println(getDateTime("yyyyMMddHHmmss", getDayBeginTime(new Date())));
		//System.out.println(getDateTime("yyyyMMddHHmmss", getDayEndTime(new Date())));
		//String startDate = DateUtil.getTurnDateStr("yyyy-mm-dd", "20110101");
		//System.out.print("startDate="+startDate);
		//sql = sql + " and A.APPLY_DATE>=to_date('" + startDate + " 00:00:00" + "','yyyy-mm-dd hh24:mi:ss')";
		//System.out.print(getTurnDateStr("yyyy-MM-dd","20111108"));
		System.out.println(DateUtil.getNowDateToTimestamp("yyyyMMddHHmms"));
	}
	
	

}
