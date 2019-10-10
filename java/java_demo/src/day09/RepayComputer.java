package day09;
import java.text.SimpleDateFormat;
import java.util.Date;
public class RepayComputer {
    //借出数量，时间，费用小计，费用总数
    private int number1;
    private int number2;
    private int number3;
    private String date;
    private double subtotal1;
    private double subtotal2;
    private double subtotal3;
    private double total;




    public int getNumber1() {
        return number1;
    }

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public int getNumber2() {
        return number2;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    public int getNumber3() {
        return number3;
    }

    public void setNumber3(int number3) {
        this.number3 = number3;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getSubtotal1() {
        return subtotal1;
    }

    public void setSubtotal1(double subtotal1) {
        this.subtotal1 = subtotal1;
    }

    public double getSubtotal2() {
        return subtotal2;
    }

    public void setSubtotal2(double subtotal2) {
        this.subtotal2 = subtotal2;
    }

    public double getSubtotal3() {
        return subtotal3;
    }

    public void setSubtotal3(double subtotal3) {
        this.subtotal3 = subtotal3;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public RepayComputer(){

    }

    public RepayComputer(int number1, int number2, int number3, String date, double subtotal1,double subtotal2,double subtotal3, double total) {
        this.number1 = number1;
        this.number2 = number2;
        this.number3 = number3;
        this.date = date;
        this.subtotal1 = subtotal1;
        this.subtotal2 = subtotal2;
        this.subtotal3 = subtotal3;
        this.total = total;
    }
}
