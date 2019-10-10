package day11.T4;

import java.util.Scanner;

public class Test {


    public double totalCalcRent(int days,MotoVehicle[] array) {
        double total=0;
        for (int i = 0; i < array.length; i++) {
            if(array[i]!=null){
                 MotoVehicle motoVehicles=array[i];
                 total+=motoVehicles.calcRent(days);
            }
        }
        return total;

    }

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int a=1;
        MotoVehicle[]  vehicle=new MotoVehicle[10];
        System.out.println("*****************新哥租车***********************");
        System.out.println("\t\t\t\t\t轿车\t\t\t\t\t\t客车\t\t\t\t\t拖拉机");
        System.out.println("车型：\t别克商务舱GL8\t宝马550i\t\t别克林荫大道\t<=16座\t>16座\t1拖箱\t2拖箱\t3拖箱");
        System.out.println("费用：\t600\t\t\t500\t\t300\t\t\t800\t\t1500\t200\t\t300\t\t500");
        System.out.println("1.租车\n2.退出");
        System.out.println("******************欢迎光临**********************");
        System.out.println("请选择序号(1？2？):");
        int number=input.nextInt();
        while (number==1){
            System.out.println("请选择输入您选择的车类(轿车？客车？拖拉机？)：");
            String cartype=input.next();
            if(cartype.equals("轿车")){
                System.out.println("请输入您要选择的车型(请按照列表选择车型号)：");
                cartype= input.next();
                for(int i=0;i<vehicle.length;i++){
                    if (vehicle[i]==null){
                        vehicle[i]=new Car("","","",0,cartype);
                        System.out.println("租车成功！");
                        break;
                    }
                }
            }else if(cartype.equals("客车")){
                System.out.println("请输入您要选择的车座数(请按照列表选择座位数)：");
                number=input.nextInt();
                for(int i=0;i<vehicle.length;i++){
                    if(vehicle[i]==null){
                        vehicle[i]=new Bus("1","1","1",1,number);
                        System.out.println("租车成功！");
                        break;
                    }
                }
            }else if(cartype.equals("拖拉机")){
                System.out.println("请选择拖箱数(请按照列表选择0-3)：");
                number=input.nextInt();
                for(int i=0;i<vehicle.length;i++){
                    if(vehicle[i]==null){
                        vehicle[i]=new Tractors("1","1","1",1,number);
                        System.out.println("租车成功！");
                        break;
                    }
                }
            }
            System.out.println("1.租车\n2.退出");
            System.out.println("请选择序号(1?2?):");
            number=input.nextInt();

        }



        Test test=new Test();
        System.out.print("请输入租车天数：");
        int days=input.nextInt();
        System.out.println("总租金为："+test.totalCalcRent(days,vehicle));
    }

}
