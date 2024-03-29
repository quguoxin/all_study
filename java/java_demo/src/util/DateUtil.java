package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2018/5/17.
 */
public class DateUtil {
    //2018-05-18 09:07:00
    public String format1 = "yyyy-MM-dd hh:mm:ss";
    public String format2 = "yyyy/MM/dd hh:mm:ss";
    public String format3 = "yyyy年MM月dd日 hh小时mm分ss秒";
    public String format4 = "yyyyMMddhhmmss";

    /**
     * 将指定时间格式化为字符串:yyyy-MM-dd hh:mm:ss
     * @param date
     * @return
     */
    public String format(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format1);
        return simpleDateFormat.format(date);
    }

    /**
     * 按照毫秒计算时间差
     * @param start
     * @param now
     * @return
     */
    public int timeInterval1(Date start, Date now){
        long distanceTime = now.getTime()-start.getTime();
        int res = (int)(distanceTime/(24*3600*1000));
        return res;
    }

    /**
     * 按照时钟类的系统方法计算时间差
     * @param start
     * @param now
     * @return
     */
    public int timeInterval(Date start, Date now) {
        Calendar calendar1 = Calendar.getInstance(); //当前日期
        int nowDay = calendar1.get(Calendar.DAY_OF_YEAR);//获得当前日期在整年中的第几天
        //System.out.println(nowDay);//31,28,30,31,17=137

        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(start);//设置指定日期
        int startDay = calendar2.get(Calendar.DAY_OF_YEAR);

        int day = nowDay - startDay;
        return day;
    }

    public static void main(String[] args) {
        DateUtil dateUtil = new DateUtil();
        System.out.println(dateUtil.format(new Date()));
        System.out.println(new Date());
    }
}
