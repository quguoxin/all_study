package day02;
import java.util.Scanner;
public class Store {
    public static void main(String[] args) {
        System.out.println("欢迎光临王者荣耀商城");
        Scanner input=new Scanner(System.in);

        System.out.println("请输入您所购买的皮肤：");
        String diRenJieSkin=input.next();
        System.out.println(diRenJieSkin+"的皮肤单价为：");
        double price1=input.nextDouble();

        System.out.println("请输入您所购买的皮肤：");
        String huaMuLanSkin=input.next();
        System.out.println(huaMuLanSkin+"的皮肤单价为：");
        double price2=input.nextDouble();

        System.out.println("请输入您所购买的皮肤：");
        String luBanSkin=input.next();
        System.out.println(luBanSkin+"的皮肤单价为：");
        double price3=input.nextDouble();
        int num=1;

        System.out.println("****************王者荣耀商城***************");
        System.out.println("购买装备\t"+diRenJieSkin+"\t"+huaMuLanSkin+"\t"+luBanSkin);
        System.out.println("购买数目\t"+num+"\t\t\t"+num+"\t\t\t"+num);
        System.out.println("消费金额\t"+price1*num+"\t\t"+price2*num+"\t\t"+price3*num);
        System.out.println("********************************************");

        System.out.println("请输入折扣：");
        double discount=input.nextDouble();
        System.out.println("实际消费："+(price1*num+price2*num+price3*num)*discount);
        System.out.println("请输入支付金额：");
        int money=input.nextInt();
        System.out.println("找零：\t"+(money-(price1*num+price2*num+price3*num)*discount));
        System.out.println("********欢迎下次光临**********");

    }
}
