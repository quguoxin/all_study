package com.qgx.www.test;

import com.alibaba.fastjson.JSON;
import com.qgx.www.entity.Choice;
import com.qgx.www.util.JedisUtil;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;


public class TestJedis {

    @Test//测试指令
    public void testJedisCommand(){
        Jedis jedis = new Jedis("127.0.0.1",6379);
        System.out.println(jedis.ping());//jedis.ping()==PONG则连接成功

        //字符串存储
        //jedis.set("周杰伦","快使用双截棍");

        //list存储
        //jedis.lpushx("瞿大爷的优点","高","富","帅");
        //jedis.lpush("周大爷的优点","高","富","帅");
        /*jedis.lpush("周大爷的优点","矮");
        jedis.lpush("周大爷的优点","矬");
        jedis.lpush("周大爷的优点","穷");*/

        //取集合
        List list= jedis.lrange("周大爷的优点",0,5);
        System.out.println(list.toString());
    }

    @Test//测试JedisUtil工具
    public void testJedisUtil(){
        JedisUtil jedisUtil =new JedisUtil();
        //增
        //jedisUtil.add("刘德华","给我一杯忘情水",-1);
        //Choice choice = new Choice(1,"晚上吃鸡腿吗？",1);
        //jedisUtil.add("选择题", JSON.toJSONString(choice),-1);
        //删
        //jedisUtil.delete("刘德华");
        //改
        jedisUtil.update("刘德华","男人哭吧哭吧不是罪",-1);
        //查
        System.out.println(jedisUtil.getByKey("刘德华"));
    }
}
