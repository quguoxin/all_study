package day17.t1;




import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class FileTest {
    int number;
    int length;
    String site;
    File file1;
    Scanner input=new Scanner(System.in);

    //查询的菜单
    public void menu(){
        System.out.println("1.查询文件（文件夹）");
        System.out.println("2.退出");
        System.out.println("请选择：");
        number=input.nextInt();
        switch (number){
            case 1:
                checkFile();
                break;
            case 2:
                System.out.println("退出成功！");
                break;
            default:
                System.out.println("输入有误");
                menu();
                break;
        }
    }

    //小菜单
    public void smallMenu(){
        System.out.println("1.创建文件");
        System.out.println("2.删除文件");
        System.out.println("3.返回");
        System.out.println("4.退出");
        System.out.println("请选择：");
        number=input.nextInt();
        switch (number){
            case 1:
                newBuilt();
                break;
            case 2:
                del();
                break;
            case 3:
                menu();
                break;
            case 4:
                System.out.println("退出成功");
                break;
            default:
                System.out.println("输入有误");
                smallMenu();
                break;
        }
    }

    //查询
    public void checkFile() {
        System.out.println("请输入文件夹路径：");
        site = input.next();
        file1 = new File(site);
        if (file1.exists()) {
            System.out.println("当前目录是：文件夹" + site);
            File[] childFile = file1.listFiles();
            System.out.println("名称\t\t\t\t\t\t\t修改时间\t\t\t类型\t\t\t大小");
            for (File child : childFile) {
                SimpleDateFormat lastDate = new SimpleDateFormat("yyyy/MM/dd");
                String date = lastDate.format(child.lastModified());
                length = child.getName().length();
                System.out.println(child.getName() + "\t\t\t\t" + date + "\t" +
                        child.getName().substring(length - 3, length) +
                        "\t\t\t" + ((child.length() / 1024) + 1) + "kb");
            }
            smallMenu();
        } else {
            System.out.println("您输入的路径有误，请重新输入！");
            checkFile();
        }

    }

    //新建
    public void newBuilt(){
        System.out.println("请输入创建文件名：");
        String name=input.next();
        File file2=new File(site,name);
        if(!file2.exists()){
            try {
                file2.createNewFile();
                System.out.println("创建成功！");
                File[] childFile=file1.listFiles();
                System.out.println("名称\t\t\t\t\t\t\t修改时间\t\t\t类型\t\t\t大小");
                for(File child:childFile){
                    SimpleDateFormat lastDate=new SimpleDateFormat("yyyy/MM/dd");
                    String date=lastDate.format(child.lastModified());
                    length=child.getName().length();
                    System.out.println(child.getName()+"\t\t\t\t"+date+"\t"+
                                       child.getName().substring(length-3,length)+"\t\t\t"+
                                       ((child.length()/1024)+1)+"kb");
                }
                smallMenu();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    //删除
    public void del(){
        System.out.println("请输入删除的文件名：");
        String name=input.next();
        File file=new File(site,name);
        if(file.exists()){
           try {
               file.delete();
               System.out.println("删除成功！");
               File[] childFile=file1.listFiles();
               System.out.println("名称\t\t\t\t\t\t\t修改时间\t\t\t类型\t\t\t大小");
               for(File child:childFile){
                   SimpleDateFormat lastDate=new SimpleDateFormat("yyyy/MM/dd");
                   String date=lastDate.format(child.lastModified());
                   length=child.getName().length();
                   System.out.println(child.getName()+"\t\t\t\t"+date+
                           "\t"+child.getName().substring(length-3,length)+
                           "\t\t\t"+((child.length()/1024)+1)+"kb");
               }
               smallMenu();
           }catch (Exception e){
               e.printStackTrace();
           }
        }

    }

    public static void main(String[] args) {
        FileTest fileTest=new FileTest();
        fileTest.menu();

    }
}
