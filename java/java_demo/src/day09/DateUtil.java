package day09;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
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


}
