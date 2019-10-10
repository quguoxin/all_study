package day19.t1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderForm {
    //键盘输入商品，返回商品对象集合
    public List<Produce> init(){
        Scanner input=new Scanner(System.in);
        System.out.println("请输入用户名：");
        String userName=input.next();
        String yAndN="Y";
        List<Produce> list=new ArrayList<Produce>();
        do{
            System.out.println("请输入选择的产品：");
            System.out.println("产品号：");
            String produceNo=input.next();
            System.out.println("产品名称：");
            String produceName=input.next();
            System.out.println("数量：");
            int produceNumber=input.nextInt();
            System.out.println("单价：");
            double producePrice=input.nextDouble();
            Produce produce=new Produce(produceName,producePrice,produceNumber);
            list.add(produce);
            System.out.println("是否继续(Y/N)：");
            yAndN=input.next();
        }while (yAndN.equals("Y"));
        return list;
    }

    //将集合存储在文件中
    public void save(Object object){

        ObjectOutputStream objectOutputStream=null;
        try {
             OutputStream outputStream=new FileOutputStream("c:\\1\\save.bin");
             objectOutputStream=new ObjectOutputStream(outputStream);
             objectOutputStream.writeObject(object);//将整个集合存储
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //将文件中的数据提取出来
    public void load(){
        ObjectInputStream objectInputStream=null;
        double sum=0;
        try {
            File file=new File("c:\\1\\save.bin");
            if(file.exists()){    //判断文件是否存在
                //存在则提取数据
                InputStream inputStream=new FileInputStream("c:\\1\\save.bin");
                objectInputStream=new ObjectInputStream(inputStream);
                List<Produce> list2=(List<Produce>) objectInputStream.readObject();//提取文件转为集合
                System.out.println("产品名\t单价\t\t数量");
                //循环输出到控制台
                 for(Produce produce:list2) {
                     System.out.println(produce.toString());
                     sum = sum + produce.getProducePrice() * produce.getProduceNumber();
                 }
                System.out.println("订单总价："+sum);
            }else {
                //不存在则进行购买并存储
                save(init());
                //再进行提取
                InputStream inputStream=new FileInputStream("c:\\1\\save.bin");
                objectInputStream=new ObjectInputStream(inputStream);
                List<Produce> list2=(List<Produce>) objectInputStream.readObject();
                System.out.println("产品名\t单价\t\t数量");
                for(Produce produce:list2) {
                    System.out.println(produce.toString());
                    sum = sum + produce.getProducePrice() * produce.getProduceNumber();
                }
                System.out.println("订单总价："+sum);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                objectInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}
