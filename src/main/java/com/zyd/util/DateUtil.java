package com.zyd.util;
/**
 * 一些时间工具类
 *
 * @author tengxf
 * @Date 2017年7月4日
 */

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static final String YYYYMMDD = "YYYYMMDD";

    public static final String YYYYMMDDHHMM = "YYYYMMDDHHMM";

    public static final String HHMMSS = "HHMMSS";
    public static final String HHmmss = "HHmmss";

    public static final String YYYYMMDD_HHMMSS = "yyyy-MM-dd HH:mm:ss";

    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

   //分录序号
	public Long ENTRY_NUMBER = 0L;
    /**
     * 获得当天的起始时间
     */
    public static String getDayStart(Date date) {
        SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
        String time = "";
        try {
            time = shortSdf.format(date) + " 00:00:00";
        } catch (Exception e) {
        }
        return time;
    }

    /**
     * 获得当天的结束时间
     */
    public static String getDayEnd(Date date) {
        SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
        String time = "";
        try {
            time = shortSdf.format(date) + " 23:59:59";
        } catch (Exception e) {
        }
        return time;

    }

    /**
     * 获取当天结束时间
     *
     * @return
     */
    public static Date getCurrentEndDate() {
        SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return shortSdf.parse(getDayEnd(new Date()));
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 获得当天的起始时间
     *
     * @param date
     *            yyyy-MM-dd
     * @return
     */
    public static Date getDayStartByStr(String date) {
        SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dateTime = null;
        try {
            dateTime = longSdf.parse(date + " 00:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateTime;
    }

    /**
     * 获得当天的结束时间
     *
     * @param date
     *            yyyy-MM-dd
     * @return
     */
    public static Date getDayEndByStr(String date) {
        SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dateTime = null;
        try {
            dateTime = longSdf.parse(date + " 23:59:59");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateTime;
    }

    /**
     * 获得当天的结束时间
     *
     * @param date
     *            yyyy-MM-dd
     * @return
     */
    public static String getStringDate(Date date, String geshi) {
        if (geshi.equals("yyyymmddhhmmss") || geshi.equals("YYYYMMDDHHMMSS")) {
            Calendar sCalendar = Calendar.getInstance();
            sCalendar.setTime(date);
            int YY = sCalendar.get(Calendar.YEAR);
            int MM = sCalendar.get(Calendar.MONTH);
            MM = MM + 1;
            int DD = sCalendar.get(Calendar.DATE);
            int HH = sCalendar.get(Calendar.HOUR);
            int MIN = sCalendar.get(Calendar.MINUTE);
            int SE = sCalendar.get(Calendar.SECOND);
            return YY + "" + MM + "" + DD + "" + HH + "" + MIN + "" + SE + "";
        } else if (geshi.equals("yyyy~mm~dd hh~mm~ss") || geshi.equals("YYYY~MM~DD HH~MM~SS")) {
            Calendar sCalendar = Calendar.getInstance();
            sCalendar.setTime(date);
            int YY = sCalendar.get(Calendar.YEAR);
            int MM = sCalendar.get(Calendar.MONTH);
            MM = MM + 1;
            int DD = sCalendar.get(Calendar.DATE);
            int HH = sCalendar.get(Calendar.HOUR);
            int MIN = sCalendar.get(Calendar.MINUTE);
            int SE = sCalendar.get(Calendar.SECOND);
            return YY + "/" + MM + "/" + DD + " " + HH + ":" + MIN + ":" + SE + "";
        } else if (geshi.equals("yyyy-mm-dd hh:mm:ss") || geshi.equals("YYYY-MM-DD HH:MM:SS")) {
            Calendar sCalendar = Calendar.getInstance();
            sCalendar.setTime(date);
            int YY = sCalendar.get(Calendar.YEAR);
            int MM = sCalendar.get(Calendar.MONTH);
            MM = MM + 1;
            int DD = sCalendar.get(Calendar.DATE);
            int HH = sCalendar.get(Calendar.HOUR);
            int MIN = sCalendar.get(Calendar.MINUTE);
            int SE = sCalendar.get(Calendar.SECOND);
            return YY + "-" + MM + "-" + DD + " " + HH + ":" + MIN + ":" + SE + "";
        } else if (geshi.equals("yyyymmdd") || geshi.equals("YYYYMMDD")) {
            Calendar sCalendar = Calendar.getInstance();
            sCalendar.setTime(date);
            int YY = sCalendar.get(Calendar.YEAR);
            int MM = sCalendar.get(Calendar.MONTH);
            MM = MM + 1;
            int DD = sCalendar.get(Calendar.DATE);
            int HH = sCalendar.get(Calendar.HOUR);
            int MIN = sCalendar.get(Calendar.MINUTE);
            int SE = sCalendar.get(Calendar.SECOND);
            String y1;
            if (YY < 10) {
                y1 = "0" + YY;
            } else {
                y1 = "" + YY;
            }
            String m1;
            if (MM < 10) {
                m1 = "0" + MM;
            } else {
                m1 = "" + MM;
            }
            String d1;
            if (DD < 10) {
                d1 = "0" + DD;
            } else {
                d1 = "" + DD;
            }
            return y1 + "" + m1 + "" + d1;
        } else if (geshi.equals("hhmmss") || geshi.equals("HHMMSS")) {
            Calendar sCalendar = Calendar.getInstance();
            sCalendar.setTime(date);
            int HH = sCalendar.get(Calendar.HOUR);
            String h1;
            if (HH < 10) {
                h1 = "0" + HH;
            } else {
                h1 = "" + HH;
            }
            int MIN = sCalendar.get(Calendar.MINUTE);
            String m1;
            if (MIN < 10) {
                m1 = "0" + MIN;
            } else {
                m1 = "" + MIN;
            }
            int SE = sCalendar.get(Calendar.SECOND);
            String s1;
            if (SE < 10) {
                s1 = "0" + SE;
            } else {
                s1 = "" + SE;
            }
            return h1 + "" + m1 + "" + s1;
        } else if (geshi.equals("hh:mm:ss") || geshi.equals("HH:MM:SS")) {
            Calendar sCalendar = Calendar.getInstance();
            sCalendar.setTime(date);
            int HH = sCalendar.get(Calendar.HOUR);
            String h1;
            if (HH < 10) {
                h1 = "0" + HH;
            } else {
                h1 = "" + HH;
            }
            int MIN = sCalendar.get(Calendar.MINUTE);
            String m1;
            if (MIN < 10) {
                m1 = "0" + MIN;
            } else {
                m1 = "" + MIN;
            }
            int SE = sCalendar.get(Calendar.SECOND);
            String s1;
            if (SE < 10) {
                s1 = "0" + SE;
            } else {
                s1 = "" + SE;
            }
            return h1 + ":" + m1 + ":" + s1;
        } else if (geshi.equals("YYYYMMDDHHMM") || geshi.equals("yyyyMMddHHMM")) {
            Calendar sCalendar = Calendar.getInstance();
            sCalendar.setTime(date);
            int YY = sCalendar.get(Calendar.YEAR);
            int MM = sCalendar.get(Calendar.MONTH);
            MM = MM + 1;
            int DD = sCalendar.get(Calendar.DATE);
            int HH = sCalendar.get(Calendar.HOUR);
            int MIN = sCalendar.get(Calendar.MINUTE);
            String y1;
            if (YY < 10) {
                y1 = "0" + YY;
            } else {
                y1 = "" + YY;
            }
            String m1;
            if (MM < 10) {
                m1 = "0" + MM;
            } else {
                m1 = "" + MM;
            }
            String d1;
            if (DD < 10) {
                d1 = "0" + DD;
            } else {
                d1 = "" + DD;
            }
            String h1;
            if (HH < 10) {
                h1 = "0" + HH;
            } else {
                h1 = "" + HH;
            }
            String m2;
            if (MIN < 10) {
                m2 = "0" + MIN;
            } else {
                m2 = "" + MIN;
            }
            return y1 + m1 + d1 + h1 + m2;
        } else {
            Calendar sCalendar = Calendar.getInstance();
            sCalendar.setTime(date);
            int YY = sCalendar.get(Calendar.YEAR);
            int MM = sCalendar.get(Calendar.MONTH);
            MM = MM + 1;
            int DD = sCalendar.get(Calendar.DATE);
            int HH = sCalendar.get(Calendar.HOUR);
            int MIN = sCalendar.get(Calendar.MINUTE);
            int SE = sCalendar.get(Calendar.SECOND);
            return YY + "-" + MM + "-" + DD + " " + HH + ":" + MIN + ":" + SE + "";
        }
    }

    // 获取 yyyy-mm-dd类型的String Date
    public static String getYYYY_MM_DD(Date d, int i) {
        if (d == null) {
            d = new Date();
        }
        Calendar sCalendar = Calendar.getInstance();
        sCalendar.setTime(d);
        sCalendar.add(Calendar.DATE, i);
        int YY = sCalendar.get(Calendar.YEAR);
        int MM = sCalendar.get(Calendar.MONTH) + 1;
        int DD = sCalendar.get(Calendar.DATE);
        String yy = "";
        String mm = "";
        String dd = "";
        if (MM < 10) {
            mm = "0" + MM;
        } else {
            mm = MM + "";
        }
        if (DD < 10) {
            dd = "0" + DD;
        } else {
            dd = "" + DD;
        }
        return YY + "-" + mm + "-" + dd;
    }

    /**
     * 返回当天时间 yyyyMMdd
     *
     * @return
     */
    public static String get() {
        SimpleDateFormat longSdf = new SimpleDateFormat(YYYYMMDD);
        return longSdf.format(new Date());
    }

    /**
     * 获取当前时间 的字符串
     *
     * @param format
     * @return
     */
    public static String getTimeStr(String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        Calendar calendar = Calendar.getInstance();
        return df.format(calendar.getTime());
    }

    public static Integer getYearAndMonth(Date date) {
        if (null == date) {
            return null;
        }
        SimpleDateFormat df = new SimpleDateFormat(YYYYMMDD);
        String dateStr = df.format(date);
        String yearAndMonth = dateStr.substring(0, 6);
        return Integer.valueOf(yearAndMonth);
    }

    public static String getYearAndMonthStr(Date date) {
        if (null == date) {
            return null;
        }
        SimpleDateFormat df = new SimpleDateFormat(YYYYMMDD);
        String dateStr = df.format(date);
        String yearAndMonth = dateStr.substring(0, 6);
        return yearAndMonth;
    }
    
    public static String getFormatDateStr(Date date, String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        return df.format(date);
    }

    public static void main(String[] args) {
        // System.out.println(getDayStart(new Date()));
        // System.out.println(getDayEnd(new Date()));
        // System.out.println(getTimeStr("HHmmss"));

        // System.out.println(DateUtils.getFormatedDate("20180305141153",
        // "yyyyMMddHHmmss"));
        System.out.println(getYearAndMonth(new Date()));
    }

    /**
	 * 字符串转换Integer string To Integer
	 * 
	 */
	public static Integer stringToInteger(String dateTime){
		String str = dateTime.substring(0,4)+dateTime.substring(5,7);
		Integer strToInt = Integer.valueOf(str);
		return strToInt;
		
	}
	
	public static Date stringToDate(String dateString) throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(dateString);
		return date;
		
	}
	
	public static Date mapstrToDate(Date dateString) throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(dateString);
		SimpleDateFormat strToDate = new SimpleDateFormat("yyyy-MM-dd");
		Date strDate = strToDate.parse(date);	
		return strDate;
		
	}
	
	public static Integer dateToInteger(Date dateToInt){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = sdf.format(dateToInt);
		String accountingPeriod = dateStr.replace("-", "").substring(0, 6);
		Integer strToInt = Integer.valueOf(accountingPeriod);
		return strToInt;		
	}
	
	public static String getFormatDateStrWithDateAndInterval(String date, String format, int intervalDays){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Calendar cd = Calendar.getInstance();
		try {
			cd.setTime(sdf.parse(date));
		} catch (ParseException e) {
			return "";
		}
		cd.add(Calendar.DAY_OF_MONTH, intervalDays);
		return sdf.format(cd.getTime());
	}
	
	public static Date getDateByInterval(String date, String format, int intervalDays){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Calendar cd = Calendar.getInstance();
		try {
			cd.setTime(sdf.parse(date));
		} catch (ParseException e) {
			return null;
		}
		cd.add(Calendar.DAY_OF_MONTH, intervalDays);
		return cd.getTime();
	}
	
	public static Date getYesterday(){
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String todayStr = sdf.format(today);
		return getDateByInterval(todayStr ,"yyyyMMdd" ,-1);
	}
	
	public static Date getToday(){
		Date today = new Date();
		return today;
	}
	
	public static Date getFormatedDate(String strDate, String formate) {
		return getFormatedDate(getDateFormat(formate), strDate);
	}
	
	private static DateFormat getDateFormat(String format) {
		return new SimpleDateFormat(format);
	}
	
	public static Date getFormatedDate(DateFormat df, String strDate) {
		try {
			return df.parse(strDate);
		} catch (Exception ex) {
			throw new RuntimeException("日期格式不对，无法解析。", ex);
		}
	}
}
