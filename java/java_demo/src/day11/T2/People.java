package day11.T2;

public class People {
    public void printss(Printer word){
         if(word instanceof Black){
             Black black=(Black)word;
             black.prints("Hello World");
         }else if(word instanceof Colour){
             Colour colour=(Colour)word;
             colour.prints("Hello World");
         }
    }

    public static void main(String[] args) {
        People people=new People();
        people.printss(new Black());
        people.printss(new Colour());
    }
}
