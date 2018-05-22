package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtils {

    /**
     * 英文简写（默认）如：2015-11-09
     */
    public static String FORMAT_SHORT = "yyyy-MM-dd";

    /**
     * 英文全称，无秒针  如：2015-11-09 12:10
     */
    public static String FORMAT_NO_SECOND = "yyyy-MM-dd HH:mm";

    /**
     * 英文全称  如：2015-11-09 12:10:08
     */
    public static String FORMAT_LONG = "yyyy-MM-dd HH:mm:ss";

    /**
     * 英文全称，无秒针  如：2015-11-09 12:10
     */
    public static String FORMAT_NO_SECOND_CN = "yyyy-MM-dd HH:mm";

    /**
     * 精确到毫秒的完整时间    如：yyyy-MM-dd HH:mm:ss.S
     */
    public static String FORMAT_FULL = "yyyy-MM-dd HH:mm:ss.S";

    /**
     * 中文简写  如：2015年11月09日
     */
    public static String FORMAT_SHORT_CN = "yyyy年MM月dd";

    /**
     * 中文全称  如：2015年11月09日  12时10分08秒
     */
    public static String FORMAT_LONG_CN = "yyyy年MM月dd日  HH时mm分ss秒";

    /**
     * 精确到毫秒的完整中文时间  如：2015年11月09日  12时10分08秒335毫秒
     */
    public static String FORMAT_FULL_CN = "yyyy年MM月dd日  HH时mm分ss秒SSS毫秒";

    // =================================================================================================================

    /**
     * 日期格式字符串转换成时间戳
     *
     * @param date_str 字符串日期
     * @param format   如：yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String dateToTimeStamp(String date_str, String format) {
        if (format == null) {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
//            return String.valueOf(sdf.parse(date_str).getTime()/1000); //返回10位的时间戳
            return String.valueOf(sdf.parse(date_str).getTime()); //返回13位的时间戳
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 将时间戳转换为时间
     */
    public static Date stampToDate(String s) throws ParseException {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        date = simpleDateFormat.parse(res);
        return date;
    }

    /**
     * 日期转换成字符串
     *
     * @param date
     * @return str
     */
    public static String DateToStr(Date date) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = format.format(date);
        return str;
    }

    /**
     * 字符串转换成日期
     *
     * @param str
     * @return date
     */
    public static Date StrToDate(String str) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 将指定格式的字符串转换为时间
     */
    public static Date parse(String date, String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        Date d = null;
        try {
            d = df.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return d;
    }

    /**
     * 将时间转换为指定格式的字符串
     */
    public static String format(Date date, String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        return df.format(date);
    }

    /**
     * 获取当前日期的后一天
     */
    public static Date getAfterDay(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE, 1);//把日期往后增加一天.整数往后推,负数往前移动
        return calendar.getTime();   //这个时间就是日期往后推一天的结果
    }

    /**
     * 获取当前日期的后一天
     */
    public static Date getBeforeDay(Date date, int day) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE, day);//把日期往后增加一天.整数往后推,负数往前移动
        return calendar.getTime();   //这个时间就是日期往后推一天的结果
    }

    /**
     * 获取时间戳
     */
    public static String getTimeString() {
        SimpleDateFormat df = new SimpleDateFormat(FORMAT_FULL);
        Calendar calendar = Calendar.getInstance();
        return df.format(calendar.getTime());
    }

    /**
     * 获取日期年份
     */
    public static String getYear(Date date) {
        SimpleDateFormat df = new SimpleDateFormat(FORMAT_FULL);
        return df.format(date).substring(0, 4);
    }

    /**
     * 功能描述：返回月
     */
    public static int getMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 功能描述：返回日
     */
    public static int getDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 功能描述：返回时
     */
    public static int getHour(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 功能描述：返回分
     */
    public static int getMinute(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MINUTE);
    }

    /**
     * 返回秒钟
     */
    public static int getSecond(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.SECOND);
    }

    /**
     * 功能描述：返回毫
     */
    public static long getMillis(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getTimeInMillis();
    }

    /**
     * 得到上周第一天
     */
    public static Date getFirstDayOfLastWeek() {
        return getFirstOfDayByDate(0, getDayOfWeekByDate(Calendar.MONDAY, -1, new Date()));
    }

    /**
     * 得到上周最后一天
     */
    public static Date getLastDayOfLastWeek() {
        return getLastOfDayByDate(0, getDayOfWeekByDate(Calendar.SUNDAY, 0, new Date()));
    }

    /**
     * 得到当周第一天
     */
    public static Date getFirstDayOfThisWeek() {
        return getFirstOfDayByDate(0, getDayOfWeekByDate(Calendar.MONDAY, 0, new Date()));
    }

    /**
     * 得到当周最后一天
     */
    public static Date getLastDayOfThisWeek() {
        return getLastOfDayByDate(0, getDayOfWeekByDate(Calendar.SUNDAY, 1, new Date()));
    }

    /**
     * 获得上月的第一天
     */
    public static Date getFirstDayOfLastMonth() {
        return getFirstOfDayByDate(0, getDayOfMonthByDate(1, -1, new Date()));
    }

    /**
     * 获得上月的最后一天
     */
    public static Date getLastDayOfLastMonth() {
        return getLastOfDayByDate(0, getDayOfMonthByDate(-1, -1, new Date()));
    }

    /**
     * 获得当月的第一天
     */
    public static Date getFirstDayOfThisMonth() {
        return getFirstOfDayByDate(0, getDayOfMonthByDate(1, 0, new Date()));
    }

    /**
     * 获得当月的最后一天
     */
    public static Date getLastDayOfThisMonth() {
        return getLastOfDayByDate(0, getDayOfMonthByDate(-1, 0, new Date()));
    }

    /**
     * 获取当天的0点
     */
    public static Date getFistOfDay(Date date) {
        return getFirstOfDayByDate(0, date);
    }

    /**
     * 获取当天的0点时间戳
     */
    public static long getFistTimeStampOfDay(Date date) {
        return getFirstOfDayByDate(0, date).getTime();
    }

    /**
     * 获取当天的24点
     */
    public static Date getLastOfDay(Date date) {
        return getLastOfDayByDate(0, date);
    }

    /**
     * 获取两个日期之间的天数
     */
    public static int getSubDaysByReport(Date startDate, Date endDate) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startStr = df.format(startDate).substring(11, 19);
        String endStr = df.format(endDate).substring(11, 19);
        long startDay = startDate.getTime();
        long endDay = endDate.getTime();
        int days = (int) ((endDay - startDay) / (1000 * 60 * 60 * 24));
        // 因为做报表的时候昨天的12到今天12点，要分成两天计算，如果不是从0点开始或者不是从0点结束，那么就手动加上一天
        if (!"00:00:00".equals(startStr) || !"00:00:00".equals(endStr)) {
            return days + 1;
        } else {
            return days;
        }
    }

    /**
     * 将指定时间加上指定天数
     */
    public static Date getAddDays(int days, Date... args) {
        Calendar calendar = Calendar.getInstance();
        for (int i = 0; i < args.length; i++) {
            calendar.setTime(args[i]);
        }
        calendar.add(Calendar.DATE, days);
        return calendar.getTime();
    }

    /**
     * 得到指定日期的前N周的第n天
     */
    public static Date getDayOfWeekByDate(int day, int week, Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        // 判断是否本身就是需要获取星期天
        if (day != Calendar.SUNDAY) {
            // 判断是否是星期天，因为JAVA中默认星期天为一周第一天，如果date和一周第一天都为星期天，则再向前推一周
            if (calendar.getFirstDayOfWeek() == Calendar.SUNDAY && calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                week -= 1;
            }
        }
        // n为推迟的周数，0本周，-1向前推迟一周，1下周，依次类推
        calendar.add(Calendar.DATE, week * 7);
        calendar.set(Calendar.DAY_OF_WEEK, day);
        return calendar.getTime();
    }

    /**
     * 得到指定月的第一天或者最后一天
     */
    public static Date getDayOfMonthByDate(int day, int month, Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        // 获取当月最后一天的方法，这个稍微要变通一下
        // 先将日期设置为下一月的第一天，然后减去一天就变成了当月的最后一天了
        if (day == -1) {
            calendar.add(Calendar.MONTH, 1);
            calendar.add(Calendar.DATE, -1);
        }
        return calendar.getTime();
    }

    /**
     * 得到指定时间的第一天和指定时间所在月的下一个月的第一天   如 2017-1-1 00:00:00
     */
    public static List<String> getDayOfMonth(String dateStamp) {
        String firstday, lastday;
        // 获取当前年份、月份、日期
        Calendar cale = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        // 获取当前月的第一天
        cale = Calendar.getInstance();
        try {
            cale.setTime(stampToDate(dateStamp));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cale.add(Calendar.MONTH, 0);
        cale.set(Calendar.DAY_OF_MONTH, 1);
        firstday = format.format(cale.getTime());
        // 获取下月的第一天
        cale.add(Calendar.MONTH, 1);
        cale.set(Calendar.DAY_OF_MONTH, 0);
        lastday = format.format(cale.getTime()); // 本月最后一天
        Date date = StrToDate(lastday + " 00:00:00"); // 最后一天转成时间
        cale.setTime(date);
        cale.get(Calendar.DATE);
        cale.set(Calendar.DATE, cale.get(Calendar.DATE) + 1); //下个月第一天
        lastday = format.format(cale.getTime());

        List<String> strings = new ArrayList<>();
        strings.add(firstday);
        strings.add(lastday);
        return strings;
    }



    /**
     * 获取指定时间的当天0点
     */
    public static Date getFirstOfDayByDate(int n, Date date) {
        String dateStr = format(date, "yyyy-MM-dd") + " 00:00:00";
        return parse(dateStr, "yyyy-MM-dd HH:mm:ss");
    }


    /**
     * 获取指定时间的当天24点
     */
    public static Date getLastOfDayByDate(int n, Date date) {
        String dateStr = format(date, "yyyy-MM-dd") + " 24:00:00";
        return parse(dateStr, "yyyy-MM-dd HH:mm:ss");
    }


}
