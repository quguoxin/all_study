package day26;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


public class TestJson {
    public static void main(String[] args) {
        //JSON对象
        JSONArray jsonArray=new JSONArray();
        JSONObject jsonObject1=new JSONObject();
        jsonObject1.put("bankCardNo","1234567890123456789");
        jsonObject1.put("balance",10000000);
        jsonObject1.put("userName","quguoxin1");
        jsonObject1.put("openDate","2018-06-25 14:12:32");
        jsonObject1.put("currentType","人民币");
        System.out.println("JSON对象：\n"+ JSON.toJSONString(jsonObject1,true));

        //JSON集合
        jsonArray.add(jsonObject1);
        JSONObject jsonObject2=new com.alibaba.fastjson.JSONObject();
        jsonObject2.put("bankCardNo","1234567890987654321");
        jsonObject2.put("balance",10000000);
        jsonObject2.put("userName","quguoxin2");
        jsonObject2.put("openDate","2018-06-25 14:14:32");
        jsonObject2.put("currentType","人民币");
        jsonArray.add(jsonObject2);
        System.out.println("\nJSON集合：\n"+JSON.toJSONString(jsonArray,true));

        //存储到BankCard中并打印
        String jsonString="{\"bankcardno\":\"1234567890123456789\",\"balance\":\"129\",\"username\":\"quguoxin\",\"opendate\":\"2018-06-25 14:42\",\"currenttype\":\"人民币\"}";
        BankCard bankCard= JSON.parseObject(jsonString,BankCard.class);
        System.out.println("\nBankCard对象：\n"+bankCard);
    }
}