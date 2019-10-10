package day15;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionTest {
    public static void main(String[] args) {
        int[] m={1,3,5,7,9};
        List list;
        list=new ArrayList();
        for(int i=0;i<m.length;i++){
            list.add(m[i]);
        }

        System.out.println("********迭代**********");
        Iterator it=list.iterator();
        while (it.hasNext()){
            Object obj=it.next();
            System.out.println(obj);
        }

        System.out.println("********foreach**********");
        for(Object obj:list){
            System.out.println(obj);
        }

        System.out.println("***********for***************");
        for(int i=0;i<list.size();i++){
            Object obj=list.get(i);
            System.out.println(obj);
        }

        list.remove(2);
        list.set(0,10);
        list.add(3,11);
        list.add(3,13);
        int size=list.size();
        System.out.println("集合的长度为："+size);

    }
}
