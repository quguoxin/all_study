package com.qgx.www.test;

import com.qgx.www.entity.Choice;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Scanner;

public class TestChoiceMapper {
    //不带参数查询
    @Test
    public void test1(){
        Reader reader= null;
        Logger logger=Logger.getLogger(this.getClass());
        try {
            //读取配置文件mybatis.xml
            logger.debug("读取配置文件mybatis.xml");
            reader = Resources.getResourceAsReader("mybatis.xml");
            logger.debug("创建会话工厂");
            //读创建会话工厂
            SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
            logger.debug("创建会话");
            //读创建会话
            SqlSession sqlSession=sqlSessionFactory.openSession();
            //通过会话调用curd操作：selectOne,selectList,insert,delete,update
            //编写sql的定位标识符字符串
            //有包路径+接口名+接口中的方法名
            String statementString="com.qgx.www.mapper.ChoiceMapper"+".findAll";
            //selectList
            List<Choice> list = sqlSession.selectList(statementString);
            //logger.info("执行查询，输出结果："+list.toString());
            System.out.println("查询第一次："+list.toString());

            sqlSession.clearCache();//清除缓存方式1：清除缓存
            //先从缓存中读取，如果缓存中存在则直接取出，如果不存在则发送sql到数据库查询数据
            List<Choice> list2 = sqlSession.selectList(statementString);
            System.out.println("查询第二次："+list2.toString());

            sqlSession.close();//清除缓存方式2：关闭连接
            SqlSession sqlSession3=sqlSessionFactory.openSession();//打开连接
            List<Choice> list3 = sqlSession3.selectList(statementString);
            System.out.println("查询第三次："+list3.toString());

            sqlSession3.close();//清除缓存方式2：关闭连接
            SqlSession sqlSession4=sqlSessionFactory.openSession();//打开连接
            List<Choice> list4 = sqlSession4.selectList(statementString);
            System.out.println("查询第四次："+list4.toString());
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("出现错误：！"+e);
        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //1个参数查询
    @Test
    public void test2(){
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
            String statementString="com.qgx.www.mapper.ChoiceMapper"+".findChoiceById";
            //selectOne
            Choice list = sqlSession.selectOne(statementString,22);
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

    //多个参数查询(模糊查询)
    @Test
    public void test3(){
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
            String statementString="com.qgx.www.mapper.ChoiceMapper"+".findChoiceByIdAndTitle";
            Choice choice = new Choice();
            choice.setId(29);
            choice.setTitle("你是男是女？");
            //selectOne
            Choice list = sqlSession.selectOne(statementString,choice);
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

    //增
    @Test
    public void test4(){
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
            String statementString="com.qgx.www.mapper.ChoiceMapper"+".addChoice";
            Choice choice = new Choice();
            choice.setTitle("邹海波上课打游戏了吗？");
            choice.setOptionType(1);
            int number= sqlSession.insert(statementString,choice);
            //事务提交
            sqlSession.commit();
            System.out.println(number);
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
    }

    //删
    @Test
    public void test5(){
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
            String statementString="com.qgx.www.mapper.ChoiceMapper"+".delChoiceById";
            int number= sqlSession.insert(statementString,30);
            //事务提交
            sqlSession.commit();
            System.out.println(number);
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
    }

    //改
    @Test
    public void test6(){
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
            String statementString="com.qgx.www.mapper.ChoiceMapper"+".updateChoiceById";
            Choice choice = new Choice();
            choice.setTitle("邹海斌上课打游戏了吗？");
            choice.setId(34);
            int number= sqlSession.insert(statementString,choice);
            //事务提交
            sqlSession.commit();
            System.out.println(number);
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
    }
}