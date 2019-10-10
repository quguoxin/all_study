package day17.t2;

import java.io.File;

public class LookFile {
    public static void main(String[] args) {
        File file=new File("C:\\test");
        System.out.println("test>>>");
            File[] childFiles=file.listFiles();
            for(int i=0;i<childFiles.length;i++){
                System.out.println("\t\t"+childFiles[i].getName()+">>>");
                if(childFiles[i].isDirectory()){   //判断文件是不是文件夹，如果是文件夹则继续遍历
                                             //如果不是就到此为止
                    File[] childFiles1=childFiles[i].listFiles();
                    for(int j=0;j<childFiles1.length;j++){
                        System.out.println("\t\t  "+childFiles1[j].getName());
                    }
                }
            }
    }
}
