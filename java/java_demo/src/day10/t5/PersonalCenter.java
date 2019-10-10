package day10.t5;

import java.util.Date;


public class PersonalCenter {
    //////////个人中心//////////////
    //属性：编号，书名，价格，借出数目，借出时间，价格小计，总计
    //方法：展示个人中心列表
    private int bookNumber;         //书的编号
    private String bookName;       //书名称
    private int repertory;        //借书数目
    private double rent;        //租金
    private double cost;      //费用
    private Date loanDate = new Date();//借出时间
    private double total;


    public PersonalCenter() {
    }

    public PersonalCenter(int bookNumber, String bookName, int repertory, double rent, double cost, Date loanDate) {
        this.bookNumber = bookNumber;
        this.bookName = bookName;
        this.repertory = repertory;
        this.rent = rent;
        this.cost = cost;
        this.loanDate = loanDate;
    }

    public int getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(int bookNumber) {
        this.bookNumber = bookNumber;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getRepertory() {
        return repertory;
    }

    public void setRepertory(int repertory) {
        this.repertory = repertory;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }


    public void showPersonalCenter(PersonalCenter[] personalCenters){
        int day;
        DateUtil dateUtil=new DateUtil();
        double total=0;
        System.out.println(">>>>>>>借书列表");
        System.out.println("图书编号\t" + "书名\t\t" + "借书数目\t\t" + "租金（每日费用）\t\t小计\t\t借出时间");
        for (int i = 0; i < personalCenters.length; i++) {
            if(personalCenters[i]==null){
                continue;
            }else {

                day = dateUtil.timeInterval(personalCenters[i].getLoanDate(),new Date());
                if(day==0){
                    day=day+1;
                }
                personalCenters[i].setCost(personalCenters[i].getRepertory()*personalCenters[i].getRent()*day);
                System.out.println(personalCenters[i].getBookNumber() +"\t" +personalCenters[i].getBookName()+"\t\t"+personalCenters[i].getRepertory()+"\t\t\t"+personalCenters[i].getRent()+"\t\t\t    "+personalCenters[i].getCost()+"\t\t"+dateUtil.format(personalCenters[i].getLoanDate()));
                total=total+personalCenters[i].getCost();
            }
        }

        System.out.println("总计："+total);

    }
}