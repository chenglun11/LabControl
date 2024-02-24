package com.lchnan7.modules.utils;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Slf4j
public class TimeUtil {



    private static final String YYYY_MM_DD = "yyyyMMdd";


    /**
     * 返回值为1,代表传入的时间大于当前时间,返回值为0,代表传入的时间和当前时间相等,返回值为-1,代表传入的时间小于当前时间
     * @param otherTime
     * @return
     * @throws ParseException
     */
    public static int compareNowTimeAndOtherTime(String otherTime) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date1 = sdf.parse(otherTime);
            Date date2 = new Date();
//        log.info("当前时间{}",sdf.format(date2));
            return date2.compareTo(date1);
        }catch (Exception e){
            e.printStackTrace();
            return -10;
        }

    }


    public static String dateRandom18() {

        //获取当前年月日
        SimpleDateFormat yyyyMMdd = new SimpleDateFormat(YYYY_MM_DD);
        String date = yyyyMMdd.format(new Date());

        //获取时间戳后6位
        String timeMillis = String.valueOf(System.currentTimeMillis());
        String fiveNumber = timeMillis.substring(timeMillis.length() - 6);

        //获取随机数后4位
        String tempRandom = String.valueOf(Math.random());
        String number = tempRandom.substring(tempRandom.length() - 4);

        //生成18位随机时间戳数字
        return date + fiveNumber + number;
    }



    /**
     * 获取当前具体时间
     * @return
     */
    public static String getCurrentTime(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    /**
     * 获取当天日期
     */
    public static String getCurrentDay(){
        return new SimpleDateFormat("MM-dd").format(new Date());
    }


    /**
     * 获取当天月份
     */
    public static String getCurrentMonth(){
        return new SimpleDateFormat("MM").format(new Date());
    }

    /**
     * 计算两个时间相差的秒数
     * @param startTime
     * @param endTime
     * @return
     * @throws ParseException
     */
    public static long getStartTimeAndEndTimeGapSecond(String startTime, String  endTime) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long eTime = df.parse(endTime).getTime();
        long sTime = df.parse(startTime).getTime();
        return (eTime - sTime) / 1000;
    }


    public static boolean compareTime(String time1,String time2) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("HH:mm");
        Date now = df.parse(df.format(new Date()));
        Date begin = df.parse(time1);
        Date end = df.parse(time2);
        Calendar nowTime = Calendar.getInstance();
        nowTime.setTime(now);
        Calendar beginTime = Calendar.getInstance();
        beginTime.setTime(begin);
        Calendar endTime = Calendar.getInstance();
        endTime.setTime(end);
        return nowTime.before(endTime) && nowTime.after(beginTime);
    }

    public static int get(){
        return 11111222;
    }

    public static int getCurrentWeekDay(){
        Date today = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(today);
        int weekday = c.get(Calendar.DAY_OF_WEEK) -1;
//        System.out.println(weekday);
        if (weekday == 0){
            return 7;
        }else {
            return weekday;
        }
    }


    /**
     * 获取多少s之前的时间
     * @param date
     * @param seconds
     * @return
     */
    public static String getBeforeSecondsTime(Date date, int seconds) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.SECOND, seconds);
        return dateFormat.format(calendar.getTime());
    }


    public static String getTimeBeforeFiveMinute(Integer min){
        Date date =  new Date();
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm");
//        System.out.println("现在时间："+df.format(date));
//        System.out.println("昨天该时间：" + );
        return df.format(new Date(date.getTime() - 60 * 1000 * min));

    }


    public static void main(String[] args) {
        System.out.println(  getTimeBeforeFiveMinute(5));
        String timeBeforeFiveMinute = getTimeBeforeFiveMinute(5);
        String[] s = timeBeforeFiveMinute.split(" ");
        System.out.println(s[1]);
//        System.out.println(  getTimeBeforeFiveMinute(10));
//        System.out.println(  getTimeBeforeFiveMinute(15));
//        System.out.println(  getTimeBeforeFiveMinute(20));
//        System.out.println(  getTimeBeforeFiveMinute(25));
//        System.out.println(  getTimeBeforeFiveMinute(30));
    }



//    public static void main(String[] args) throws ParseException {
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String endTime=new String("2022-03-08 11:22:22");
//        Date sd1=df.parse(endTime);
//        Date sd2 = new Date();
//        long time1 = sd1.getTime();
//        long time2 = sd2.getTime();
////        System.out.println(time1);
////        System.out.println(time2);
////        System.out.println(time1 > time2);
//
//    }
}
