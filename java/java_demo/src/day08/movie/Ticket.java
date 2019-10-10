package day08.movie;

public class Ticket {
    //价格price，日期date，电影名称filmName，座位号seatNum，放映厅videoHall，电影院名称cinema
      private double price;
      private String date;
      private String filmName;
      private int[][] seatNum={
              {0, 0, 0, 0, 0, 0},
              {0, 0, 0, 0, 0, 0},
              {0, 0, 0, 0, 0, 0},
              {0, 0, 0, 0, 0, 0},
              {0, 0, 0, 0, 0, 0},
              {0, 0, 0, 0, 0, 0},
              {0, 0, 0, 0, 0, 0},
              {0, 0, 0, 0, 0, 0},
              {0, 0, 0, 0, 0, 0},
              {0, 0, 0, 0, 0, 0},
      };
      private int videoHall;
      private String cinema;

    public void showTicket(){
        System.out.println("*************票根************/n电影院名称："+cinema+
                           "\n电影："+filmName+"\n单价："+price+"\n影厅："+videoHall+"\n日期："+date+"\n座位："+seatNum+
        "/n************************");
    }
    public Ticket(){
        this.price = price;
        this.date = date;
        this.filmName = filmName;
        this.seatNum = seatNum;
        this.videoHall = videoHall;
        this.cinema = cinema;
    }
    public Ticket(double price, String date, String filmName, int[][] seatNum, int videoHall, String cinema) {
        this.price = price;
        this.date = date;
        this.filmName = filmName;
        this.seatNum = seatNum;
        this.videoHall = videoHall;
        this.cinema = cinema;
    }
}
