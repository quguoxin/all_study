package day10.t5;


public class BookCnter {
    /////////书/////////////
    //属性：编号，书名，价格，库存数量，
    private int bookNumber;         //书的编号
    private String bookName;       //书名称
    private int repertory;        //库存
    private double rent;        //租金




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

    public BookCnter() {
    }

    public BookCnter(int bookNumber, String bookName, int repertory, double rent) {
        this.bookNumber = bookNumber;
        this.bookName = bookName;
        this.repertory = repertory;
        this.rent = rent;
    }

    //展示图书列表
    public void showBookCnter(BookCnter[] bookCnters){
        System.out.println(">>>>>>>图书列表");
        System.out.println("图书编号\t" + "书名\t\t\t" + "库存\t\t" + "租金（每日费用）");
        for (int i = 0; i < bookCnters.length; i++) {
            System.out.println(bookCnters[i].getBookNumber() +"\t" +bookCnters[i].getBookName()+"\t\t"+bookCnters[i].getRepertory()+"\t\t"+bookCnters[i].getRent());
        }
    }
}
