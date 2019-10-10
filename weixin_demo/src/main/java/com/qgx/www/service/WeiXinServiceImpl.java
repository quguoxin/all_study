package com.qgx.www.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qgx.www.contant.DataContant;
import com.qgx.www.util.HttpClientUtil;
import com.qgx.www.util.JedisUtil;
import org.apache.commons.lang3.StringUtils;



public class WeiXinServiceImpl {

    /**
     * 获取令牌
     * @return
     */
    public static String getAccessRoken(){
        String access_token= JedisUtil.getInstance().getByKey("access_token");
        if(StringUtils.isEmpty(access_token)){
            String url="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+ DataContant.APPID+"&secret="+DataContant.APPSECRET;
            String res= HttpClientUtil.getJson(url);
            JSONObject jsonObject=JSONObject.parseObject(res);
            access_token=jsonObject.getString("access_token");
            JedisUtil.getInstance().add("access_token",access_token,2*60*60);
        }
        return access_token;
    }

    /**
     * 获取用户列表
     */
    public JSONArray getUserList(){
        String url = "https://api.weixin.qq.com/cgi-bin/user/get?access_token="+getAccessRoken();
        String res = HttpClientUtil.getJson(url);
        JSONObject jsonObject= JSONObject.parseObject(res);
        JSONObject data=jsonObject.getJSONObject("data");
        System.out.println(res);
        return data.getJSONArray("openid");
    }

    /**
     * 发送信息
     *
     */
    public String sendKfMsg(){
        String url = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token="+getAccessRoken();
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("touser","oI1hh1m9DGRTbRghmVrO8gTFzZoo");
        /*jsonObject.put("msgtype","text");
        JSONObject text = new JSONObject();
        text.put("content","瞿国新发送的消息");
        jsonObject.put("text",text);*/

        jsonObject.put("msgtype","news");
        JSONObject articles1=new JSONObject();
        //1个
        articles1.put("title","hao123网站");
        articles1.put("description","呵呵呵呵呵呵");
        articles1.put("url","www.hao123.com");
        articles1.put("picurl","http://mmbiz.qpic.cn/mmbiz_jpg/AV0SuSRoU9r73fmGw4YCMWg6icgt7fEgNMmSic05ICtswYiatXTy1BmAhEjTCj5l0lGN3ptuibML4ia5B5umqOPmAqw/0");
        JSONArray articles=new JSONArray();
        articles.add(articles1);
        //2个.....
        JSONObject news=new JSONObject();
        news.put("articles",articles);
        jsonObject.put("news",news);
        String body= JSON.toJSONString(jsonObject);
        String res = HttpClientUtil.postJson(url,body,"UTF-8");
        return res;
    }


    /**
     * 创建菜单
     */
    public String addMenu(){
        String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token="+getAccessRoken();
        JSONObject jsonObject=new JSONObject();//---->button
        JSONArray jsonArray=new JSONArray();//一级菜单

        JSONObject gequ = new JSONObject();//1:歌曲
        gequ.put("type","click");
        gequ.put("name","为你写诗");
        gequ.put("key","V1001_WEINI_XIESHI");
        jsonArray.add(gequ);//添加一个按钮

        JSONObject wyds = new JSONObject();//2:我要读诗
        wyds.put("name","我要读诗");
        JSONArray sub_buttonArray = new JSONArray();
        JSONObject sub1 = new JSONObject();//2.1 第二个菜单(我要读诗)里面的第一个子菜单：我要读诗
        sub1.put("type","view");
        sub1.put("name","我要读诗");
        sub1.put("url","https://www.jianshu.com/p/75d0e8f9a2d3");
        sub_buttonArray.add(sub1);

        JSONObject sub2 = new JSONObject();//2.2 第二个菜单(我要读诗)里面的第二个子菜单：发送位置
        sub2.put("type","location_select");
        sub2.put("name","发送位置");
        sub2.put("key","V1002_FASONG_WEIZHI");
        sub_buttonArray.add(sub2);

        JSONObject sub3 = new JSONObject();//2.3 第二个菜单(我要读诗)里面的第三个子菜单：拍照
        sub3.put("type","pic_sysphoto");
        sub3.put("name","拍照");
        sub3.put("key","V1003_PAI_ZHAO");
        sub_buttonArray.add(sub3);

        JSONObject sub4 = new JSONObject();//2.4 第二个菜单(我要读诗)里面的第四个子菜单：扫码提示
        sub4.put("type","scancode_waitmsg");
        sub4.put("name","扫码提示");
        sub4.put("key","V1004_SAOMA_TISHI");
        sub_buttonArray.add(sub4);

        wyds.put("sub_button",sub_buttonArray);
        jsonArray.add(wyds);//再次添加一个按钮

        jsonObject.put("button",jsonArray);
        String body= JSON.toJSONString(jsonObject);
        String res = HttpClientUtil.postJson(url,body,"UTF-8");
        return res;
    }


    /**
     * 购买成功
     */
    public String goumai(){
        String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+getAccessRoken();
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("touser","oI1hh1mC19jTT6qGfdTQi1Qiuk8A");
        jsonObject.put("template_id","e0wRIhxRbOBL2FJ4s8Rd1uHgY4ISP3zUGsak_bIrV1g");
        //jsonObject.put("url","https://ngrok.cc/user.html");

        /*JSONObject miniprogram=new JSONObject();
        miniprogram.put("appid","wxfbdc4139f5b2330b");
        miniprogram.put("pagepath","pages/index/index");
        jsonObject.put("miniprogram",miniprogram);*/

        JSONObject data=new JSONObject();
        JSONObject first=new JSONObject();
        first.put("value","恭喜你购买成功！");
        first.put("color","#173177");
        data.put("first",first);

        JSONObject keyword1=new JSONObject();
        keyword1.put("value","梅赛德斯-AMG C 63 轿跑车");
        keyword1.put("color","#7A378A");
        data.put("keyword1",keyword1);

        JSONObject keyword2=new JSONObject();
        keyword2.put("value","95.88万");
        keyword2.put("color","#ED0301");
        data.put("keyword2",keyword2);

        JSONObject keyword3=new JSONObject();
        keyword3.put("value","2018-8-28 22:59:10 ");
        keyword3.put("color","#173177");
        data.put("keyword3",keyword3);

        JSONObject remark=new JSONObject();
        remark.put("value","欢迎再次购买！");
        remark.put("color","#173177");
        data.put("remark",remark);

        jsonObject.put("data",data);
        String body= JSON.toJSONString(jsonObject);
        String res = HttpClientUtil.postJson(url,body,"UTF-8");
        return res;
    }
}
