package com.lchnan7.modules.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class EchartUtils {


    /**
     * 获取近三年
     */
    public static List<String> recentThreeYear(){
        List<String> data = new ArrayList<>();
        data.add("2023");
        data.add("2024");
        data.add("2025");
        return data;
    }

    /**
     * 获取今年12个月
     */
    public static List<String> recentTwelveMonth(){
        List<String> data = new ArrayList<>();
        data.add("1月");
        data.add("2月");
        data.add("3月");
        data.add("4月");
        data.add("5月");
        data.add("6月");
        data.add("7月");
        data.add("8月");
        data.add("9月");
        data.add("10月");
        data.add("11月");
        data.add("12月");
        return data;
    }

    /**
     * 获取近七天
     * @return
     */
    public static List<String> recentSevenDay(){
        ArrayList<String> pastDaysList = new ArrayList<>();
        try {
            //我这里传来的时间是个string类型的，所以要先转为date类型的。
            SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(getCurrentDay());
            for (int i = 6; i >= 0; i--) {
                pastDaysList.add(getPastDate(i,date));
            }
        }catch (ParseException e){
            e.printStackTrace();
        }
        Collections.reverse(pastDaysList);
        return pastDaysList;
    }



    public static String getPastDate(int past,Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + past);
        Date today = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String result = sdf.format(today);
        return result;
    }
    public static String getCurrentDay(){
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }
}
