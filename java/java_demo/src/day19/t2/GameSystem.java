package day19.t2;

import com.sun.javafx.collections.MappingChange;

import java.io.*;
import java.util.*;

public class GameSystem {

    //读（调用）
    public Map readFile(String name){
        ObjectInputStream objectInputStream=null;
        Map map=null;
        try {
            InputStream inputStream=new FileInputStream(name);
            if(inputStream.available()<=0){
                return null;
            }
            objectInputStream=new ObjectInputStream(inputStream);
            map=(Map)objectInputStream.readObject();
        }catch (Exception e){
            //e.printStackTrace();
        }finally {
            try {
                objectInputStream.close();
            } catch (Exception e) {
                //e.printStackTrace();
            }
        }
        return map;
    }

    //存
    public void saveFile(Map map,String name){
        ObjectOutputStream objectOutputStream=null;
        try {
            OutputStream outputStream=new FileOutputStream(name);
            objectOutputStream=new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(map);//将整个集合存储
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
}
