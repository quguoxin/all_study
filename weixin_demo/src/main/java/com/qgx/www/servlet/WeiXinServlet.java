package com.qgx.www.servlet;


import com.alibaba.fastjson.JSONObject;
import com.qgx.www.util.SHA1;
import net.sf.json.xml.XMLSerializer;
import org.apache.commons.io.IOUtils;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet(urlPatterns = "/weiXin.s")
public class WeiXinServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get-验证服务器地址的有效性");
        String signature = req.getParameter("signature");
        String nonce = req.getParameter("nonce");
        String timestamp = req.getParameter("timestamp");
        String echostr = req.getParameter("echostr");
        String token = "quguoxin";
        System.out.println("signature-"+signature+" nonce-"+nonce+" timestamp-"+timestamp+" echostr-"+echostr+" token-"+token);
        PrintWriter printWriter = resp.getWriter();
        //开发者通过检验signature对请求进行校验（下面有校验方式）。若确认此次GET请求来自微信服务器，请原样返回echostr参数内容，则接入生效，成为开发者成功，否则接入失败。加密/校验流程如下：
        //1）将token、timestamp、nonce三个参数进行字典序排序
        String[] array = {token,timestamp,nonce};
        Arrays.sort(array);
        // 2）将三个参数字符串拼接成一个字符串进行sha1加密
        String tmp = array[0]+array[1]+array[2];
        String tmp2 = SHA1.encode(tmp);
        // 3）开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
        if(tmp2.equals(signature)){
            printWriter.write(echostr);
        }else {
            printWriter.write("");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();
        InputStream io=null;
        try {
            System.out.println("post-接收微信请求");
            req.setCharacterEncoding("UTF-8");
            io=req.getInputStream();//接收用户发的信息，平台把信息封装成xml数据包
            String xmlString = IOUtils.toString(io,"UTF-8");
            //转成json对象
            XMLSerializer xmlSerializer = new XMLSerializer();
            String jsonString = xmlSerializer.read(xmlString).toString();
            JSONObject jsonObject = JSONObject.parseObject(jsonString);
            System.out.println(jsonObject.getString("Content"));
            String content = jsonObject.getString("Content");
            String msgType = jsonObject.getString("MsgType");
            String event = jsonObject.getString("Event");
            String respContext = "";
            //msgtype:text,image,voice,voide,shortvideo,location,link,even
            //event:subscribe(订阅)、unsubscribe(取消订阅),LOCATION,CLICK,VIEW
            if(msgType.equals("text")){//接收发送消息
                if(content.equals("1")){
                    respContext="查看新闻";
                }else if(content.equals("2")){
                    respContext="查看积分";
                }else if(content.equals("3")){
                    respContext="进行充值";
                }else if(content.equals("4")){
                    respContext="查看余额";
                }else {
                    respContext="有待开发";
                }
            }else if(msgType.equals("event")){//接收推送事件
                if(event.equals("CLICK")){
                    respContext="别点了，还没开发！";
                }else if(event.equals("subscribe")){
                    respContext="欢迎关注新哥科技公众号！\n1.查看新闻\n2.查看积分\n3.充值\n4.查看余额！";
                }
            }
            //平台被自动回复消息给用户，返回xml文件给微信平台，微信平台解析给用户字符信息
            String responseXmlString = "<xml>\n" +
                    "    <ToUserName><![CDATA["+jsonObject.getString("FromUserName")+"]]>\n" +
                    "    </ToUserName>\n" +
                    "    <FromUserName><![CDATA["+jsonObject.getString("ToUserName")+"]]>\n" +
                    "    </FromUserName>\n" +
                    "    <CreateTime>"+System.currentTimeMillis()+"</CreateTime>\n" +
                    "    <MsgType><![CDATA[text]]>\n" +
                    "    </MsgType>\n" +
                    "    <Content><![CDATA["+respContext+"]]>\n" +
                    "    </Content>\n" +
                    "</xml>";
            System.out.println("响应的xml："+responseXmlString);
            printWriter.write(responseXmlString);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            io.close();
        }
    }
}
