package day16;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class StudentRank {
    public static void main(String[] args) {
            Set<Student> set=new TreeSet<Student>();
            set.add(new Student(1001,"张一",89));
            set.add(new Student(1003,"张三",98));
            set.add(new Student(1002,"张二",60));
            set.add(new Student(1005,"张五",75));
            set.add(new Student(1004,"张四",86));


        Iterator<Student> it=set.iterator();
        while (it.hasNext()){
            Object o=it.next();
            System.out.println(o.toString());
        }

    }
}
