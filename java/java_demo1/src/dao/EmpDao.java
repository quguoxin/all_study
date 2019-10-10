package dao;

import entity.Emp;

import java.util.List;

public interface EmpDao {
    public List<Emp> getEmp(String job);
}
