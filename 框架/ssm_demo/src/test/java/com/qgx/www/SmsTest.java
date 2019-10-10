package com.qgx.www;

import com.alibaba.fastjson.JSONObject;
import com.qgx.www.sms.SysConfig;
import com.qgx.www.util.HttpClientUtil;
import org.junit.Test;


public class SmsTest {
    @Test
    public void sendTest(){
        int randomString=(int) Math.random()*10000;
        String sid = "a13a2f9945d0ad3b158ccefda7d46a22";//用户id
        String token = "491fa66932cb2e0d80bd52a59a747e86";//鉴权密匙
        String appid = "3c69c30c94584aac9ddc7abc2fa5483b";//应用id
        String templateid = "364523";//短信模板编号【新新科技】您的验证码是{1}，请在{2}秒内输入。
        String param = randomString+","+60;//模板中的参数占位用数据，号隔开
        String mobile = "";//要发送的手机号码
        String uid = "sdfsdkjfhsdkjhkjsdkfjhskdhfsdkjhfkdsj";//用户透传ID，随状态报告返回给什么返回什么

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sid", sid);
        jsonObject.put("token", token);
        jsonObject.put("appid", appid);
        jsonObject.put("templateid", templateid);
        jsonObject.put("param", param);
        jsonObject.put("mobile", mobile);
        jsonObject.put("uid", uid);

        String body = jsonObject.toJSONString();
        System.out.println(body);

        //获取请求服务器
        String server= SysConfig.getInstance().getProperty("rest_server");
        StringBuffer sb = new StringBuffer("https://");
        sb.append(server).append("/ol/sms");
        String url = sb.append("/sendsms").toString();
        //目的拼接成  http:open.ucpaas.com/ol/sms/sendsms

        String result= HttpClientUtil.postJson(url,body,null);
        System.out.println("返回结果："+result);
    }
}
