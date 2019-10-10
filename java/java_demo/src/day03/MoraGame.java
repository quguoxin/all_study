package day03;
import java.util.Scanner;
public class MoraGame {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int computer=(int)(Math.random()*3);
        System.out.println("请输入：");
        int player=input.nextInt();
        if(player>=0&&player<=2){
            switch (player){
                case 0:
                    System.out.println("石头");
                    if(computer==0){
                        System.out.println("打平！");
                        System.out.println("电脑出的是：石头");
                    }else if(computer==1){
                        System.out.println("恭喜你，你赢了！");
                        System.out.println("电脑出的是：剪刀");
                    }else{
                        System.out.println("很遗憾，你输了！");
                        System.out.println("电脑出的是：布");
                    }
                break;
                case 1:
                    System.out.println("剪刀");
                    if(computer==0){
                        System.out.println("很遗憾，你输了");
                        System.out.println("电脑出的是：石头");
                    }else if(computer==1){
                        System.out.println("打平！");
                        System.out.println("电脑出的是：剪刀");
                    }else {
                        System.out.println("恭喜你，你赢了！");
                        System.out.println("电脑出的是：布");
                    }
                break;
                default:
                    System.out.println("布");
                    if(computer==0){
                        System.out.println("恭喜你，你赢了！");
                        System.out.println("电脑出的是：石头");
                    }else if(computer==1){
                        System.out.println("很遗憾，你输了");
                        System.out.println("电脑出的是：剪刀");
                    }else{
                        System.out.println("打平！");
                        System.out.println("电脑出的是：布");
                    }
                break;
            }
        }else {
            System.out.println("您的输入有误！");
        }

    }
}
