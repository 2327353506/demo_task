package demo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author wangmt
 * @date 2017/11/20
 */
public class DateHelper {

    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private static final String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";


    /**
     * 获取当前时间（yyyy-MM-dd）
     * @return
     */
    public static String getCurrentDate(){
        return getFormatDate(new Date(),DATE_FORMAT);
    }

    /**
     * 获取当前时间（yyyy-MM-dd HH:mm:ss）
     * @return
     */
    public static String getCurrentTime(){
        return getFormatDate(new Date(),TIME_FORMAT);
    }

    /**
     * 获得自定义格式的当前时间
     * @param fmt
     * @return
     */
    public static String getFormatDate(String fmt){
        return getFormatDate(new Date(),fmt);
    }
    /**
     * 获取（yyyy-MM-dd）格式时间
     * @param date
     * @return
     */
    public static String getFormatDate(Date date){
        return getFormatDate(date,DATE_FORMAT);
    }
    /**
     * 获取（yyyy-MM-dd HH:mm:ss）格式时间
     * @param date
     * @return
     */
    public static String getFormatTime(Date date){
        return getFormatDate(date,TIME_FORMAT);
    }

    /**
     * 获取自定义格式时间
     * @param fmt
     * @param date
     * @return
     */
    public static String getFormatDate(Date date,String fmt){
        SimpleDateFormat sdf = new SimpleDateFormat(fmt);
        return sdf.format(date);
    }

    /**
     * 加减时间的处理
     * @param d 时间
     * @param i 加减的数量
     * @param calendar 加减类型 Calendar.YEAR,Calendar.MONTH 等
     * @return
     */
    public static Date addDate(Date d,int i ,int calendar){
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        c.add(calendar, i);
        return c.getTime();
    }

    /**
     * 加减时间的处理（格式化后）
     * @param d 时间
     * @param i 加减的数量
     * @param calendar 加减类型 Calendar.YEAR,Calendar.MONTH 等
     * @param fmt 时间格式化
     * @return
     */
    public static String addDate(Date d, int i , int calendar, String fmt){
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        c.add(calendar, i);
        return getFormatDate(c.getTime(),fmt);
    }

    /**
     * 字符串时间转时间
     * @param date 转换的时间
     * @param fmt 格式化时间
     * @return
     * @throws ParseException
     */
    public static Date toDate(String date,String fmt) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(fmt);
        return sdf.parse(date);
    }
    /**
     * 字符串时间(yyyy-MM-dd)转时间
     * @param date 转换的时间
     * @return
     * @throws ParseException
     */
    public static Date toDate(String date) throws ParseException {
        return toDate(date,DATE_FORMAT);
    }
    /**
     * 字符串时间(yyyy-MM-dd HH:mm:ss)转时间
     * @param date 转换的时间
     * @return
     * @throws ParseException
     */
    public static Date toTime(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(TIME_FORMAT);
        return toDate(date,TIME_FORMAT);
    }



}
