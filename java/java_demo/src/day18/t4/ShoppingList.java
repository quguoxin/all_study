package day18.t4;



import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingList {
    //读清单
    public List<CommodityList> readList(String readPaths){
        BufferedReader bufferedReader=null;
        List<CommodityList> list=new ArrayList<CommodityList>();
        try {
            Reader reader=new FileReader(readPaths);//创建字符流对象，读取文件
            bufferedReader=new BufferedReader(reader);//创建缓冲流对象
            String lineString=bufferedReader.readLine();//先读取一行给到字符串，剔除开头无关文字
            do{
                lineString=bufferedReader.readLine();//正式按行读取我们需要的数据并存储
                if(lineString!=null){   //可以有效避免结束时读到空行报错
                    String[]array=lineString.split(" ");//将字符转为字符串数组为集合存储做准备
                    CommodityList commodityList =
                     new CommodityList(array[0],array[1],array[2],array[3]);//创建清单对象并初始化
                    list.add(commodityList);//将所得对象储存在集合中
                }
            }while(lineString!=null);
            return list;//返回集合
        }catch (Exception e){
            try {
                bufferedReader.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        return null;
    }

    //写购物小票
    public void writeList(String writePaths,List<CommodityList> list){
        double sum=0;
        String str="编号\t名称\t价格\t数目\t小计";
        for(CommodityList commodityList:list){
            double subtotal=Integer.parseInt(commodityList.getCommodityNumber())*Integer.parseInt(commodityList.getCommodityPrice());
            sum+=subtotal;
            str+="\r\n"+commodityList.getCommodityNo()+"\t"+commodityList.getCommodityName()+"\t"+commodityList.getCommodityPrice()+"\t"+commodityList.getCommodityNumber()+"\t"+subtotal;
        }
        str=str+"\r\n"+"消费：¥"+sum+"\r\n"+"付款：¥"+40000+"\r\n"+"折扣："+0.8+"\r\n"+"找零：¥"+(40000-sum*0.8);
        System.out.println(str);
        BufferedWriter bufferedWriter=null;
        try {
            Writer writer=new FileWriter(writePaths);
            bufferedWriter=new BufferedWriter(writer);
            bufferedWriter.write(str);
        }catch (Exception e){
            try {
                bufferedWriter.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ShoppingList shoppingList=new ShoppingList();
        shoppingList.writeList("d:\\1\\2.txt",shoppingList.readList("c:\\1\\购物清单.txt"));
    }
}
