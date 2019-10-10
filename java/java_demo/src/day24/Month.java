package day24;

public enum Month {

    JANUARY(1,"我是一月份","元旦节"),
    FEBRUARY(2,"我是二月份","情人节"),
    MARCH(3,"我是三月份","妇女节"),
    APRIL(4,"我是四月份","愚人节"),
    MAY(5,"我是五月份","劳动节"),
    JUNE(6,"我是六月份","儿童节"),
    JULY(7,"我是七月份","建党节"),
    AUGUST(8,"我是八月份","建军节"),
    SEPTEMBER(9,"我是九月份","教师节"),
    OCTOBER(10,"我是十月份","国庆节"),
    NOVEMBER(11,"我是十一月份","国际大学生节 "),
    DECEMBER(12,"我是十二月份","圣诞节");

    private int monthNo;
    private String monthShow;
    private String festival;

    @Override
    public String toString() {
        return name() +"("+ monthNo+","+monthShow+","+festival+")";
    }

    public static Month getByNo(int no){
        Month obj=null;
        Month[] month2=Month.values();
        for(Month month:month2){
            if(month.getMonthNo()==no){
                obj=month;
                break;
            }
        }
        return obj;
    }

    Month(int monthNo, String monthShow, String festival) {
        this.monthNo = monthNo;
        this.monthShow = monthShow;
        this.festival = festival;
    }

    public int getMonthNo() {
        return monthNo;
    }

    public void setMonthNo(int monthNo) {
        this.monthNo = monthNo;
    }

    public String getMonthShow() {
        return monthShow;
    }

    public void setMonthShow(String monthShow) {
        this.monthShow = monthShow;
    }

    public String getFestival() {
        return festival;
    }

    public void setFestival(String festival) {
        this.festival = festival;
    }
}
