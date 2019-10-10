package com.qgx.www.test;

import com.qgx.www.entity.Choice;
import com.qgx.www.entity.Insurance;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.*;

public class TestInsuranceMapper {

    //菜单
    public void menu(){
        System.out.println("1.按保险人姓名查");
        System.out.println("2.按工号查");
        System.out.println("3.按被保险人证件号查");
        System.out.println("4.按被保险人证件类型查");
        System.out.println("5.投保");
        System.out.println("6.退出");
        System.out.println("请选择:");
    }

    //公共部分(查)
    public List<Insurance> commonality(Map map){
        Reader reader= null;
        try {
            //读取配置文件mybatis.xml
            reader = Resources.getResourceAsReader("mybatis.xml");
            //读创建会话工厂
            SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
            //读创建会话
            SqlSession sqlSession=sqlSessionFactory.openSession();
            //通过会话调用curd操作：selectOne,selectList,insert,delete,update
            //编写sql的定位标识符字符串
            //有包路径+接口名+接口中的方法名
            String statementString="com.qgx.www.mapper.InsuranceMapper.findByParams3";
            //selectList
            List<Insurance> list = sqlSession.selectList(statementString,map);
            sqlSession.close();//如果当sqlSession需要频繁的创建，那么业务结果时就关闭
            return list;
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    //增
    public int add(String method,Insurance insurance){
        Reader reader= null;
        SqlSession sqlSession=null;
        try {
            //读取配置文件mybatis.xml
            reader = Resources.getResourceAsReader("mybatis.xml");
            //读创建会话工厂
            SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
            //读创建会话
             sqlSession=sqlSessionFactory.openSession();
            //通过会话调用curd操作：selectOne,selectList,insert,delete,update
            //编写sql的定位标识符字符串
            //有包路径+接口名+接口中的方法名
            String statementString="com.qgx.www.mapper.InsuranceMapper."+method;
            //selectList
            int i = sqlSession.insert(statementString,insurance);
            //事务提交
            sqlSession.commit();
            sqlSession.close();
            return i;
        } catch (IOException e) {
            e.printStackTrace();
            //事务回滚
            sqlSession.rollback();
        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    //系统
    /*public void insuranceSystem(){
        String method="";
        Insurance insurance=new Insurance();
        menu();
        Scanner input =new Scanner(System.in);
        int number=input.nextInt();
        switch (number){
            case 1:
                method="findInsuranceByName";
                System.out.println("请输入姓名");
                String userName= input.next();
                insurance.setUserName(userName);
                List<Insurance> list1=commonality(insurance);
                System.out.println(list1.toString());
                insuranceSystem();
                break;
            case 2:
                method="findInsuranceByJobNum";
                System.out.println("请输入工号");
                String userJobNum= input.next();
                insurance.setUserJobNum(userJobNum);
                List<Insurance> list2=commonality(insurance);
                System.out.println(list2.toString());
                insuranceSystem();
                break;
            case 3:
                method="findInsuranceByPapersNo";
                System.out.println("请输入证件号");
                String papersNo= input.next();
                insurance.setPapersNo(papersNo);
                List<Insurance> list3=commonality(insurance);
                System.out.println(list3.toString());
                insuranceSystem();
                break;
            case 4:
                method="findInsuranceByPapersType";
                System.out.println("请输入证件类型");
                String papersType= input.next();
                insurance.setPapersType(papersType);
                List<Insurance> list4=commonality(insurance);
                System.out.println(list4.toString());
                insuranceSystem();
                break;
            case 5:
                method="addInsurance";
                System.out.println("请输入姓名");
                String userName2= input.next();
                System.out.println("请输入工号");
                String userJobNum2= input.next();
                System.out.println("请输入证件号");
                String papersNo2= input.next();
                System.out.println("请输入证件类型");
                String papersType2= input.next();
                Insurance insurance2=new Insurance(userName2,userJobNum2,papersNo2,papersType2);
                int i = add(method,insurance2);
                if(i==1){
                    System.out.println("增加成功！");
                    insuranceSystem();
                }
                break;
            case 6:
                System.exit(0);
                break;
            default:
                System.out.println("输入错误！请重新输入");
                insuranceSystem();
                break;
        }
    }*/

    //系统(验证choose 传map集合)
    public void insuranceSystem2(){
        String method="";
        Insurance insurance=new Insurance();
        menu();
        Scanner input =new Scanner(System.in);
        int number=input.nextInt();
        switch (number){
            case 1:
                System.out.println("请输入姓名");
                String userName= input.next();
                //insurance.setUserName(userName);
                Map map=new HashMap();
                map.put("searchBy","userName");
                map.put("paramsValue",userName);
                List<Insurance> list1=commonality(map);
                System.out.println(list1.toString());
                insuranceSystem2();
                break;
            case 2:
                method="findInsuranceByJobNum";
                System.out.println("请输入工号");
                String userJobNum= input.next();
                //insurance.setUserJobNum(userJobNum);
                Map map2=new HashMap();
                map2.put("searchBy","userJobNum");
                map2.put("paramsValue",userJobNum);
                List<Insurance> list2=commonality(map2);
                System.out.println(list2.toString());
                insuranceSystem2();
                break;
            case 3:
                method="findInsuranceByPapersNo";
                System.out.println("请输入证件号");
                String papersNo= input.next();
                Map map3=new HashMap();
                map3.put("searchBy","papersNo");
                map3.put("paramsValue",papersNo);
                List<Insurance> list3=commonality(map3);
                System.out.println(list3.toString());
                insuranceSystem2();
                break;
            case 4:
                method="findInsuranceByPapersType";
                System.out.println("请输入证件类型");
                String papersType= input.next();
                Map map4=new HashMap();
                map4.put("searchBy","papersType");
                map4.put("paramsValue",papersType);
                List<Insurance> list4=commonality(map4);
                System.out.println(list4.toString());
                insuranceSystem2();
                break;
            case 5:
                method="addInsurance";
                System.out.println("请输入姓名");
                String userName2= input.next();
                System.out.println("请输入工号");
                String userJobNum2= input.next();
                System.out.println("请输入证件号");
                String papersNo2= input.next();
                System.out.println("请输入证件类型");
                String papersType2= input.next();
                Insurance insurance2=new Insurance(userName2,userJobNum2,papersNo2,papersType2);
                int i = add(method,insurance2);
                if(i==1){
                    System.out.println("增加成功！");
                    insuranceSystem2();
                }
                break;
            case 6:
                System.exit(0);
                break;
            default:
                System.out.println("输入错误！请重新输入");
                insuranceSystem2();
                break;
        }
    }

    public static void main(String[] args) {
        TestInsuranceMapper testInsuranceMapper=new TestInsuranceMapper();
        testInsuranceMapper.insuranceSystem2();
    }

    @Test
    public void checkForeach(){
        Reader reader= null;
        try {
            //读取配置文件mybatis.xml
            reader = Resources.getResourceAsReader("mybatis.xml");
            //读创建会话工厂
            SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
            //读创建会话
            SqlSession sqlSession=sqlSessionFactory.openSession();
            //通过会话调用curd操作：selectOne,selectList,insert,delete,update
            //编写sql的定位标识符字符串
            //有包路径+接口名+接口中的方法名
            String statementString="com.qgx.www.mapper.InsuranceMapper.findByParams5";
            List list_id=new ArrayList();
            list_id.add(1);
            list_id.add(2);
            list_id.add(3);
            list_id.add(6);
            Map map =new HashMap();
            map.put("userName","%张%");
            //selectList
            List<Insurance> list = sqlSession.selectList(statementString,map);
            sqlSession.close();//如果当sqlSession需要频繁的创建，那么业务结果时就关闭
            System.out.println(list.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void checkTrim1(){
        Reader reader= null;
        try {
            //读取配置文件mybatis.xml
            reader = Resources.getResourceAsReader("mybatis.xml");
            //读创建会话工厂
            SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
            //读创建会话
            SqlSession sqlSession=sqlSessionFactory.openSession();
            //通过会话调用curd操作：selectOne,selectList,insert,delete,update
            //编写sql的定位标识符字符串
            //有包路径+接口名+接口中的方法名
            String statementString="com.qgx.www.mapper.InsuranceMapper.findByParams6";
            Insurance insurance=new Insurance();
            insurance.setUserName("张学友");
            //selectList
            List<Insurance> list = sqlSession.selectList(statementString,insurance);
            sqlSession.close();//如果当sqlSession需要频繁的创建，那么业务结果时就关闭
            System.out.println(list.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void checkTrim2(){
        Reader reader= null;
        try {
            //读取配置文件mybatis.xml
            reader = Resources.getResourceAsReader("mybatis.xml");
            //读创建会话工厂
            SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
            //读创建会话
            SqlSession sqlSession=sqlSessionFactory.openSession();
            //通过会话调用curd操作：selectOne,selectList,insert,delete,update
            //编写sql的定位标识符字符串
            //有包路径+接口名+接口中的方法名
            String statementString="com.qgx.www.mapper.InsuranceMapper.findByParams7";
            Insurance insurance=new Insurance();
            insurance.setUserName("周廷斯");
            insurance.setId(6);
            //selectList
            int a = sqlSession.update(statementString,insurance);
            sqlSession.commit();
            sqlSession.close();//如果当sqlSession需要频繁的创建，那么业务结果时就关闭
            System.out.println(a);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
