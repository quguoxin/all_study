import dao.impl.EmpDaoImpl;
import entity.Emp;

import java.util.List;

public class TestEmp {
    public static void main(String[] args) {
        EmpDaoImpl empDaoImpl=new EmpDaoImpl();
        List<Emp> list=empDaoImpl.getEmp("clerk");
        for(Emp temp:list){
            System.out.println(temp.toString());
        }

    }
}
